Networks P2P


## Install

`npm install --save react-native-p2p`

#### Android

**android/settings.gradle**

```
include ':react-native-p2p'
project(':react-native-p2p').projectDir = new File('../node_modules/react-native-p2p/android')
```

**android/app/build.gradle**

```
dependencies {
    ...
    compile project(':react-native-p2p')
}
```

**MainApplication.java**

```
import com.shapi.p2p.P2PPackage;
...
protected List<ReactPackage> getPackages() {
    return Arrays.<ReactPackage>asList(
        new MainReactPackage(),
        new P2PPackage()
    );
}
```
