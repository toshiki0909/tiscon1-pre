
## intelliJからのプロジェクトclone手順

1. Check out fromVersion Control > Git
2. Git Repository URLに下記を記載
   https://github.com/tiscon/tiscon1-pre.git
3. Cloneボタンを押下
 
## ローカルでの稼働確認

Mavenで`waitt:run`を実行します。10秒ほどでアプリケーションが起動するので、ブラウザから http://localhost:8080 にアクセスするとトップページが開きます。
  
## tiscon1-preの構成

```
◆tiscon1-pre
└◆src
　└◆main
    ├◆java
    │└◆tiscon1
    │　├◆config
    │　├◆controller
    │　├◆form
    │　├◆interception
    │　├◆model
    │　├◆repository
    │　└App.java アプリケーション実行クラス
    └◆resources
      └◆template htmlファイル
```

## Heroku

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)