#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Copyright (C), 2017, matrix

from flask import render_template

from service.application.controllers.data import data


@data.route('/', methods=['GET', 'POST'])  # 指定路由为/，因为run.py中指定了前缀，浏览器访问时，路径为http://IP/asset/
def index():
    print('__name__', __name__)
    return render_template('data/index.html')  # 返回index.html模板，路径默认在templates下


@data.route('/handle', methods=['GET', 'POST'])  # 指定路由为/，因为run.py中指定了前缀，浏览器访问时，路径为http://IP/asset/handle
def handle():
    print('编写逻辑')
    return "{'code': 0, 'msg': 'success'}"
