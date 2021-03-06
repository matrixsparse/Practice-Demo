# Djanago项目

## 上传代码

```bash
将window本地的代码上传到虚拟机上
```

## 准备Django环境

### 安装Anaconda

```bash
./Anaconda2-5.0.1-Linux-x86_64.sh
```

### 查看安装的内容

```bash
conda list
```

### 配置环境

```bash
[root@sparsematrix ~]# conda create -n dms-py python=2.7
```

### 激活环境

```bash
[root@sparsematrix ~]# source activate dms-py
```

### 列出所有环境

```bash
conda info --envs
```

or

```bash
conda env list
```

### 安装djanago

```bash
[root@sparsematrix ~]# conda install django MySQL-python
```

```bash
/usr/local/anaconda2/envs/dms-py/bin/pip install django-crontab django-tasks
```

## 启动Django项目

```base
python manage.py runserver 0.0.0.0:8000
```
