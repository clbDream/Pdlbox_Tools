# 潘多拉-工具库(已加入反996工作制开源协议)

开发一套纯粹的工具库

[![](https://jitpack.io/v/com.gitee.clbDream/pdl-box_tools.svg)](https://jitpack.io/#com.gitee.clbDream/pdl-box_tools)
[![LICENSE](https://img.shields.io/badge/license-Anti%20996-blue.svg)](https://github.com/996icu/996.ICU/blob/master/LICENSE)

![](images/banner.png)

## 简介

这是一个Android开发工具库系列开源项目,不包含任何隐私信息的搜集,完全可以通过国内应用市场隐私合规的检测,现在开源,供广大Android开发程序员同胞使用,欢迎大家一起来进行维护

我也是个萌新程序员,项目有什么地方不足,请多多指教,哈哈

#### 作者的其他开源项目

* 多功能记录项目<事迹>
  ：[RecordThings-Android](https://github.com/clbDream/RecordThings-Android) ![](https://img.shields.io/github/stars/clbDream/RecordThings-Android.svg) ![](https://img.shields.io/github/forks/clbDream/RecordThings-Android.svg)
* 常用第三方库集合<库多多>
  ：[Pdlbox_Library](https://github.com/clbDream/Pdlbox_Library) ![](https://img.shields.io/github/stars/clbDream/Pdlbox_Library.svg) ![](https://img.shields.io/github/forks/clbDream/Pdlbox_Library.svg)

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

可使用浏览器Ctrl+F快捷键利用关键字查找

* ### 日志 相关 -> LogUtils.kt

```
setNeedLog                : 是否打印日志
i                         : 输出日志
d                         : 输出日志
e                         : 输出日志
v                         : 输出日志
```

* ### 日期 相关 -> DateUtils.kt

```
millis2String              : 时间戳转换为日期字符串
string2millis              : 日期字符串转换为时间戳
```

* ### 时间 相关 -> TimeUtils.kt

```
millis2String               : 时间戳转换为时间字符串
string2millis               : 时间字符串转换为时间戳
longFormatTime              : 格式化时间戳为 几分钟前 本周 刚刚这种类型
minutesAgo                  : 几分钟以前
isToday                     : 是否是今天
isYestYesterday             : 是否是去年
isThisWeek                  : 是否是本周
isThisYear                  : 是否是今年
```

* ### 转换 相关 -> ConversionUtils.kt

```
dp2px, px2dp               : dp 与 px 转换
sp2px, px2sp               : sp 与 px 转换
```

* ### 字符串 相关 -> StringUtils.kt

```
isEmpty                                   : 判断内容是否为空
isBlank                                   : 判断内容是否为空或空格
equalsIgnoreCase                          : 判断str1和str2是否相同(不区分大小写)
contains                                  : 判断字符串str1是否包含字符串str2
toLowerCase                               : 将给定字符串中给定的区域的字符转换成小写
toUpperCase                               : 将给定字符串中给定的区域的字符转换成大写
firstLetterToLowerCase                    : 将给定字符串的首字母转为小写
firstLetterToUpperCase                    : 将给定字符串的首字母转为大写
replace                                   : 替换字符串中指定字符
generateRandomStrNumberAndLetter          : 随机生成指定长度的字符串(数字加字母)
generateRandomStrChinese                  : 随机生成指定长度的字符串(中文)
```

* ### 尺寸 相关 -> SizeUtils.kt

```
dp2px, px2dp               : dp 与 px 转换
sp2px, px2sp               : sp 与 px 转换
```

* ### 正则匹配 相关 -> RegexUtils.kt(部分正则会随着后续政策改变会不适用,建议正则判断以后端匹配为准)

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

* ### 距离 相关 -> DistanceUtils.kt

```
mmToCm                       : 毫米转厘米
cmToMm                       : 厘米转毫米
cmToDecimeter                : 厘米转分米
decimeterToCm                : 分米转厘米
decimeterToM                 : 分米转米
mToDecimeter                 : 米转分米
metersToKilometers           : 米转千米
kilometerToMeter             : 千米转米
```

* ### Toast 相关 -> ToastUtils.kt

```
showShort                    : 显示短期Toast
showLong                     : 显示长期Toast
```

* ### Sp存储 相关 -> SpUtils.kt

```
put                          : 存储数据
getString                    : 获取字符串
getBoolean                   : 获取布尔值
getFloat                     : 获取浮点值
getInt                       : 获取整型值
getLong                      : 获取Long值
remove                       : 删除某个文件中指定key的值
clear                        : 清空某个文件
contains                     : 查询某个key是否存在
getAll                       : 获取所有的键值对
```

* ### SD卡相关的辅助类 相关 -> SDCardUtils.kt

```
isSDCardEnable               : 判断SDCard是否可用
sDCardPath                   : 获取SD卡路径
sDCardAllSize                : 获取SD卡的剩余容量 单位byte
getFreeBytes                 : 获取指定路径所在空间的剩余可用容量字节数，单位byte
rootDirectoryPath            : 获取系统存储路径
```

* ### 获得屏幕相关的辅助类 相关 -> ScreenUtils.kt

```
getScreenWidth               : 获得屏幕宽度
getScreenHeight              : 获得屏幕高度
getStatusHeight              : 获得状态栏的高度 
snapShotWithStatusBar        : 获取当前屏幕截图，包含状态栏
snapShotWithoutStatusBar     : 获取当前屏幕截图，不包含状态栏
getScreenOrientation         : 获取屏幕方向
isLandscape                  : 屏幕是否是横向
isPortrait                   : 屏幕是否是竖向
```

* ### App相关工具类 相关 -> AppUtils.kt

```
getAppName                  : 获取应用程序名称
getVersionName              : 当前应用的版本名称
getPackageName              : 当前应用的包名
```

* ### 软键盘 相关 -> KeyBoardUtils.kt

```
openKeybord                 : 打开软键盘
closeKeybord                : 关闭软键盘
```

* ### 网络相关 相关 -> NetUtils.kt

```
isConnected                 : 判断网络是否连接
isWifi                      : 判断是否是wifi连接
isMobilNet                  : 判断是否是移动网络
openSetting                 : 打开网络设置界面
```

* ### 设备信息 相关 -> DeviceUtils.kt

```
isDeviceRooted              : 判断设备是否 rooted
isAdbEnabled                : 判断设备 ADB 是否可用
getSDKVersionName           : 获取设备系统版本号
getSDKVersionCode           : 获取设备系统版本码
getAndroidID                : 获取设备 AndroidID
getManufacturer             : 获取设备厂商
getModel                    : 获取设备型号
getABIs                     : 获取设备 ABIs
isTablet                    : 判断是否是平板
isEmulator                  : 判断是否是模拟器
wifiEnabled                 : 判断wifi是否可用
```

* ### 剪切板 相关 -> ClipboardUtils.kt

```
copyText                    : 复制文本到剪切板
getText                     : 获取剪切板本文
clear                       : 清除剪切板内容
```

* ### 拼音 相关 -> PinyinUtils.kt

```
getPingYin                  : 将字符串中的中文转化为拼音,其他字符不变
getFirstSpell               : 汉字转换为汉语拼音首字母，英文字符不变
```

* ### Gson 相关 -> GsonUtils.kt

```
getGson                     : 获取Gson对象
toJson                      : 对象转json字符串
fromJson                    : json字符串转对象
```

* ### 编码 相关 -> EncodeUtils.kt

```
encodeBase64                : base64编码
decodeBase64                : base64解码
```

* ### 表情 相关 -> EmojiUtils.kt

```
containsEmoji               : 检测是否包含表情
isEmojiCharacter            : 判断是否是表情字符
```

* ### 图片加载 相关 -> GlideUtils.kt

```
clearDiskCache              : 清理缓存
showImg                     : 加载正常图片
showRoundCornerImg          : 加载圆角图片(可指定圆角位置)
showRoundImg                : 加载圆形图片
showGigImg                  : 加载Gif动图
```

* ### 手机号码相关 相关 -> PhoneUtils.kt

```
phoneNumberHide              : 手机号隐藏部分号码(非手机号原样返回）
```

* ### 数字格式化 相关 -> NumberFormatUtils.kt

```
numberFormat                  : 数字格式化(保留1位小数）
keepTwoDecimalPlaces          : 保留两位小数(去掉最后的0）
customDecimalPlaces           : 自定义小数位数
```