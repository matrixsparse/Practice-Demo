package com.matrix.hystrix.ha.controller;

import com.matrix.hystrix.ha.http.HttpClientUtils;
import com.matrix.hystrix.ha.hystrix.GetProductInfoCommand;
import com.matrix.hystrix.ha.hystrix.GetProductInfosCommand;
import com.matrix.hystrix.ha.model.ProductInfo;
import com.netflix.hystrix.Hystrix;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rx.Observable;
import rx.Observer;

/**
 * 缓存服务的接口
 */
@Controller
public class CacheController {

    @RequestMapping("/change/product")
    @ResponseBody
    public String changeProduct(Long productId) {
        // 拿到一个商品id
        // 调用商品服务的接口，获取商品id对应的商品的最新数据
        // 用HttpClient去调用商品服务的http接口

        // 往http接口发送一条消息，就认为是通知缓存服务，有一个商品的数据变更了
        String url = "http://127.0.0.1:8082/getProductInfo?productId=" + productId;
        String response = HttpClientUtils.sendGetRequest(url);
        System.out.println(response);

        return "success";
    }

    /**
     * nginx开始，各级缓存都失效了，nginx发送很多的请求直接到缓存服务要求拉取最原始的数据
     */
    @RequestMapping("/getProductInfo")
    @ResponseBody
    public String getProductInfo(Long productId) {
        // 拿到一个商品id
        // 调用商品服务的接口，获取商品id对应的商品的最新数据
        // 用HttpClient去调用商品服务的http接口
        HystrixCommand<ProductInfo> getProductInfoCommand = new GetProductInfoCommand(productId);
        ProductInfo productInfo = getProductInfoCommand.execute();

        System.out.println(productInfo);
        return "success";
    }

    /**
     * 一次性批量查询多条商品数据的请求
     */
    @RequestMapping("/getProductInfos")
    @ResponseBody
    public String getProductInfos(String productIds) {
        HystrixObservableCommand<ProductInfo> getProductInfosCommand =
                new GetProductInfosCommand(productIds.split(","));
        Observable<ProductInfo> observable = getProductInfosCommand.observe();

//		observable = getProductInfosCommand.toObservable(); // 还没有执行

        observable.subscribe(new Observer<ProductInfo>() { // 等到调用subscribe然后才会执行

            public void onCompleted() {
                System.out.println("获取完了所有的商品数据");
            }

            public void onError(Throwable e) {
                e.printStackTrace();
            }

            public void onNext(ProductInfo productInfo) {
                System.out.println(productInfo);
            }

        });
        return "success";
    }
}
