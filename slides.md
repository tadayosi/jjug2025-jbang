---
marp: true
theme: default
paginate: true
---

![h:50px](images/jbang-logo.png)

# Javaはスクリプト言語だ

― JBangが変えるJava開発の未来

2025-06-07
[JJUG CCC 2025 Spring](https://ccc2025spring.java-users.jp/)

---

## 自己紹介

![bg left:40% h:60%](images/profile.png)

佐藤 匡剛 (さとう ただよし)

X: [@tadayosi](https://x.com/tadayosi) / GitHub: [tadayosi](https://github.com/tadayosi)

プリンシパルソフトウェアエンジニア @ Red Hat
(7月よりIBMに移籍)

OSSコミッター

- Apache Camel
- Hawtio

---

## JBang

<https://www.jbang.dev/>

![JBang website](./images/jbang-website.png)

---

## なぜJBang？

- Javaはフットワークが重い
- JBangは 1スクリプト ＝ 1プロジェクト
- 実行ランタイムは堅牢なJavaそのもの
- IDEサポート／エコシステムの充実
- 次世代Java開発／コード共有のかたち？

---

## :bulb: これからのJava開発はJBangだけでイケるのでは？

![bg right:50% h:60%](images/nobita.jpg)

---

## インストール

:point_right: <https://www.jbang.dev/download/>

### curl

```console
curl -Ls https://sh.jbang.dev | bash -s - app setup
```

### sdkman

```console
sdk install jbang
```

### homebrew

```console
brew install jbangdev/tap/jbang
```

---

## はじめる

### init

```console
jbang init hello.java
```

### run

```console
./hello.java
```

```console
jbang hello.java
```

```console
jbang https://gist.github.com/tadayosi/43dc74403c7acce5384c23129fbeb918
```

---

### build

```console
jbang build --build-dir <path> hello.java
```

### native

```console
jbang build --build-dir <path> --native hello.java
```

---

### :information_source: ファイルヘッダーの秘密

```java
///usr/bin/env jbang "$0" "$@" ; exit $?
```

Javaでスクリプト `#!` をマネするハック

:point_right: <https://golangcookbook.com/chapters/running/shebang/>

---

## 依存のインポート

```java
//DEPS org.slf4j:slf4j-api:2.0.17
//DEPS org.slf4j:slf4j-simple:2.0.17
```

### BOMも使える

```java
//DEPS org.slf4j:slf4j-bom:2.0.17@pom
//DEPS org.slf4j:slf4j-api
//DEPS org.slf4j:slf4j-simple
```

---

### :information_source: Maven Central Search (`mcs`コマンド)

<https://github.com/mthmulders/mcs>

```console
$ mcs org.slf4j:slf4j-api
...

  Coordinates                        Last updated
  ===========                        ============
  org.slf4j:slf4j-api:2.0.17         26 Feb 2025 at 01:43 (JST)
  org.slf4j:slf4j-api:2.0.16         10 Aug 2024 at 18:15 (JST)
  org.slf4j:slf4j-api:2.0.15         08 Aug 2024 at 21:59 (JST)
  ...
```

---

### リポジトリ

```java
//REPOS central,jitpack,myrepo=https://myrepo.local/maven
```

| 名前 | 説明 |
| ---- | ---- |
| `central` | <https://repo1.maven.org/maven2/> |
| `google` | <https://maven.google.com/> |
| `jitpack` | <https://jitpack.io/> |

---

### その他のタグ

```java
//JAVA 21+

//COMPILE_OPTIONS --enable-preview --verbose

//RUNTIME_OPTIONS --add-opens java.base/java.net=ALL-UNNAMED

//NATIVE_OPTIONS -O1 -g

//PREVIEW

//MODULE <module-name>

//MAIN <main-class-name>

//MANIFEST Built-By=JBang

...
```

---

## マルチファイル

Sources

```java
//SOURCES GreetingService.java
//SOURCES model/Person.java
```

Resources

```java
//FILES application.properties
//FILES META-INF/resources/index.html=index.html
```

---

## IDEとの連携

```console
jbang edit greet.java
jbang edit --sandbox greet.java
jbang edit --sandbox --no-open greet.java
```

### IDEプラグイン

- [VS Code](https://marketplace.visualstudio.com/items?itemName=jbangdev.jbang-vscode)
- [IntelliJ](https://plugins.jetbrains.com/plugin/18257-jbang)

---

### エクスポート

フルスペックの開発にもすぐ移行できる

```console
jbang export maven app.java
jbang export gradle app.java
```

---

## 実践編

1. REST
2. gRPC
3. AI / LLM

---

## CLI開発

```console
jbang init --template=cli cli.java
```

### picocli

<https://picocli.info/>

---

### JBangベースのCLI

- [Camel](https://camel.apache.org/manual/camel-jbang.html) — Integration framework
- [Hawtio](https://hawt.io/docs/get-started.html) — Management console
- [Citrus](https://citrusframework.org/samples/jbang/) — BDD integration testing framework

---

## カタログ

`jbang-catalog.json`

<https://github.com/user/repo> にある場合

```console
jbang my-cli@user/repo
```

<https://github.com/user/jbang-catalog> にある場合

```console
jbang my-cli@user
```

### 例

<https://github.com/apache/camel/blob/main/jbang-catalog.json>

---

### アプリとしてインストール

```console
jbang app install my-cli@user/repo

my-cli
```

---

### 公式カタログ

```console
jbang catalog list
```

- [Alibaba](https://github.com/alibaba/jbang-catalog)
- [Apple](https://github.com/jbanghub/apple)
- [Microsoft](https://github.com/microsoft/jbang-catalog)
- [Oracle (GraalPy)](https://github.com/oracle/graalpython)
- ...

---

## まとめ

:bulb: これからのJava開発はJBangだけでイケるのでは？ :bulb:

### プレゼン資料／ソースコード

<https://github.com/tadayosi/jjug2025-jbang>
