# -*- coding: utf-8 -*-
# 初始化文件

from flask import Blueprint

home = Blueprint("home",__name__)

import app.home.views