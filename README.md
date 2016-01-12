# TISCON pre

ECサイトのExampleアプリケーションです。
現段階ではユーザ登録、ログイン/ログアウトのみ実装してあります。

セキュリティ・性能・ユーザビリティ、保守性などの観点から、再考したほうがよい点を洗い出し、実装してください。

## Spring Boot

Exapmleアプリケーションは、Spring Bootを使って構築されています。Spring Bootに関しては以下をお読みください。


- [Spring Bootリファレンス(本家)](http://docs.spring.io/spring-boot/docs/1.3.1.RELEASE/reference/htmlsingle/)
- [Spring Bootハンズオン](http://jsug-spring-boot-handson.readthedocs.org/en/latest/)

## GitHubでのFork

`https://github.com/tiscon/tiscon1-pre.git` を各自のユーザスペースにフォークしてください。


## intelliJからのプロジェクトclone手順

1. Check out fromVersion Control > Git
2. Git Repository URLに
   https://github.com/[ユーザ名]/tiscon1-pre.git
3. Cloneボタンを押す
 
## ローカルでの稼働確認

Mavenで`waitt:run`を実行します。10秒ほどでアプリケーションが起動するので、ブラウザから http://localhost:8080 にアクセスするとトップページが開きます。

WAITTに関しては下記記事をお読みください。

http://qiita.com/kawasima/items/1d4daed6f980b4bfbee3

## tiscon1-preの構成

```
tiscon1-pre
└ src
 └ main
    ├ java
    │└ tiscon1
    │  ├ config     アプリケーションの設定
    │  ├ controller コントローラ
    │  ├ form       HTTPリクエストパラメータを受けるためのクラス群
    │  ├ interceptor  認証・認可用のインタセプタ
    │  ├ model        データモデルを表すクラス群
    │  ├ repository   モデルの永続化のためのインタフェース
    │  └ App.java アプリケーションエントリーポイント
    └ resources
      ├ public   画像, Javascript, Stylesheetなどstaticなファイル
      └ template Freemarkerテンプレート
```

## Heroku

未動作
[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)