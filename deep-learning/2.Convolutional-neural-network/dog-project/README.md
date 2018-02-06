# dog project

在这一项目中，你将学到如何建立一个处理现实生活中的，用户提供的图像的算法

给你一个狗的图像，你的算法将会识别并估计狗的品种，如果提供的图像是人，代码将会识别最相近的狗的品种

![All text](http://ww1.sinaimg.cn/large/dc05ba18gy1fo6rhwrky9j20e00goak6.jpg)

>下载狗狗数据集 ，并将数据集解压大存储库中，地点为项目路径/dogImages

```bash
[matrix@sparsematrix dog-project]$ wget https://s3.cn-north-1.amazonaws.com.cn/static-documents/nd101/v4-dataset/dogImages.zip
```

>下载人类数据集。并将数据集解压大存储库中，位置为项目路径/lfw

```bash
[matrix@sparsematrix dog-project]$ wget https://s3.cn-north-1.amazonaws.com.cn/static-documents/nd101/v4-dataset/lfw.zip
```

>为狗狗数据集下载 VGG-16关键特征 并将其放置于存储库中，位置为项目路径/bottleneck_features

```bash
[matrix@sparsematrix dog-project]$ wget https://s3.cn-north-1.amazonaws.com.cn/static-documents/nd101/v4-dataset/DogVGG16Data.npz
```

## 安装必要的 Python 依赖包

### 对于 Mac/OSX：

>创建环境

```bash
conda env create -f requirements/dog-linux.yml
```

>进入环境

```bash
source activate dog-project
```

```bash
KERAS_BACKEND=tensorflow python -c "from keras import backend"
```

>退出环境

```bash
source deactivate
```

>requirements/dog-linux.yml

```bash
name: dog-project
channels:
- defaults
dependencies:
- openssl=1.0.2l=0
- pip=9.0.1=py36_1
- python=3.6.1=2
- readline=6.2=2
- setuptools=27.2.0=py36_0
- sqlite=3.13.0=0
- tk=8.5.18=0
- wheel=0.29.0=py36_0
- xz=5.2.2=1
- zlib=1.2.8=3
- pip:
  - bleach==2.0.0
  - cycler==0.10.0
  - decorator==4.0.11
  - entrypoints==0.2.3
  - h5py==2.6.0
  - html5lib==0.999999999
  - ipykernel==4.6.1
  - ipython==6.1.0
  - ipython-genutils==0.2.0
  - ipywidgets==6.0.0
  - jedi==0.10.2
  - jinja2==2.9.6
  - jsonschema==2.6.0
  - jupyter==1.0.0
  - jupyter-client==5.0.1
  - jupyter-console==5.1.0
  - jupyter-core==4.3.0
  - keras==2.0.2
  - markupsafe==1.0
  - matplotlib==2.0.0
  - mistune==0.7.4
  - nbconvert==5.2.1
  - nbformat==4.3.0
  - notebook==5.0.0
  - numpy==1.12.0
  - olefile==0.44
  - opencv-python==3.2.0.6
  - pandocfilters==1.4.1
  - pexpect==4.2.1
  - pickleshare==0.7.4
  - pillow==4.0.0
  - prompt-toolkit==1.0.14
  - protobuf==3.3.0
  - ptyprocess==0.5.1
  - pygments==2.2.0
  - pyparsing==2.2.0
  - python-dateutil==2.6.0
  - pytz==2017.2
  - pyyaml==3.12
  - pyzmq==16.0.2
  - qtconsole==4.3.0
  - scikit-learn==0.18.1
  - scipy==0.18.1
  - simplegeneric==0.8.1
  - six==1.10.0
  - tensorflow==1.0.0
  - terminado==0.6
  - testpath==0.3.1
  - theano==0.9.0
  - tornado==4.5.1
  - tqdm==4.11.2
  - traitlets==4.3.2
  - wcwidth==0.1.7
  - webencodings==0.5.1
  - widgetsnbextension==2.0.0
```

## 打开 notebook

```bash
jupyter notebook dog_app.ipynb --ip=0.0.0.0
```