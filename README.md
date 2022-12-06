# 潘多拉-工具库

开发一套纯粹的工具库

[![](https://jitpack.io/v/com.gitee.clbDream/pdl-box_tools.svg)](https://jitpack.io/#com.gitee.clbDream/pdl-box_tools)

## 简介

这是一个Android开发工具库系列开源项目,不包含任何隐私信息的搜集,完全可以通过国内应用市场隐私合规的检测,现在开源,供广大Android开发程序员同胞使用,欢迎大家一起来进行维护

我也是个萌新程序员,项目有什么地方不足,请多多指教,哈哈

## 如何使用

1. Add the JitPack repository to your build file

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

2. Add the dependency(版本信息查看上面的标签里面)

```
dependencies {
	        implementation 'com.gitee.clbDream:pdl-box_tools:$version'
	}
```

## 功能列表

* ### 日期 相关 -> [DateUtils.kt][DateUtils.kt] -> [Demo][DateTest.demo]

```
formatDateToString              : 格式化日期时间戳为字符串
```