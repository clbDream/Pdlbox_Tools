# 潘多拉-工具库(已加入反996工作制开源协议)

开发一套纯粹的工具库

[![](https://jitpack.io/v/com.gitee.clbDream/pdl-box_tools.svg)](https://jitpack.io/#com.gitee.clbDream/pdl-box_tools)
[![LICENSE](https://img.shields.io/badge/license-Anti%20996-blue.svg)](https://github.com/996icu/996.ICU/blob/master/LICENSE)

![](images/banner.png)

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

* ### 日期 相关 -> DateUtils.kt

```
millis2String              : 时间戳转换为日期字符串
string2millis              : 日期字符串转换为时间戳
```

* ### 时间 相关 -> TimeUtils.kt

```
millis2String              : 时间戳转换为时间字符串
string2millis              : 时间字符串转换为时间戳
```

* ### 转换 相关 -> ConversionUtils.kt

```
dp2px, px2dp               : dp 与 px 转换
sp2px, px2sp               : sp 与 px 转换
```

* ### 字符串 相关 -> StringUtils.kt

```
isEmpty                    : 判断内容是否为空
isBlank                    : 判断内容是否为空或空格
equalsIgnoreCase           : 判断str1和str2是否相同(不区分大小写)
contains                   : 判断字符串str1是否包含字符串str2
```

* ### 尺寸 相关 -> SizeUtils.kt

```
dp2px, px2dp               : dp 与 px 转换
sp2px, px2sp               : sp 与 px 转换
```

* ### 正则匹配 相关 -> RegexUtils.kt

```
isMatch                    : 判断是否匹配正则
isPhoneNumberStrict        : 验证是否是手机号(严格)
isPhoneNumberSimple        : 验证是否是手机号(宽松)
isLegalName                : 验证输入的名字是否为“中文”或者是否包含“·”
isLegalId                  : 验证是否是身份证号
isEmail                    : 验证是否是邮箱
matchChinese               : 判断是不是中文
isTime                     : 判断是不是时间
isIpV4                     : 判断是不是ipv4
isDate                     : 判断是不是日期
isCarNumber                : 判断是否是车牌号
```