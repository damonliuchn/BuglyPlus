# BuglyPlus

Bugly Android SDK 封装: 包含App升级功能，Maven引用即可，不用关心AndroidManifest里的权限、Activity和Proguard混淆。


# Usage:

```goovy
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}

	dependencies {
	        compile 'com.github.MasonLiuChn:BuglyPlus:1.3.3.1'
	}
```

```java
BuglyUtil.init(this, appId, channel);
```

```java
BuglyUtil.checkUpgrade(boolean isManual);
```

# Contact me:

Blog:http://blog.csdn.net/masonblog

Email:MasonLiuChn@gmail.com

# License:
    Copyright 2017 MasonLiu, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


