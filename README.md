## GitHub 使い方

# IH4C_G3_android

## プロジェクトを自分のPCにダウンロードの仕方（クローンの仕方）

まずはVisual Studioのターミナルかコマンドプロンプトを開きAndroidStudioProjectsのフォルダまでに移動します。

```bash
例：
PC/ユーザー/AndroidStudioProjects
cd C:\Users\NHS90324\AndroidStudioProjects
```

移動出来たら次のコマンドを実行する（githubをインストールしてないとできません）

```bash
 git clone https://github.com/tanakaho/IH4C_G3_android.git
```
これでインストールが開始されます。
インストール・更新はコマンドプロンプトかVSで行う必要があります（VSの場合は簡単にできます）
開発自体はAndroid Studioを利用して開発します。

### 1.GitHubにプッシュ（アップ）の仕方（VSなら下にあります）

## 1.1ステージに追加し、コミット

`git status`

git add するファイル(自分の担当ファイルのみか)を確認する。

**data.sqliteが合った場合は以下のコマンドを打つ！**

`git restore data.sqlite`

`git status`

（現在の状況をもう一度確認し、余計なファイルがないか再確認）

`git add .`

`git status`

（現在の状況を確認する）

`git commit -m "コミットメッセージ"`

`git status`

（現在の状況を確認する）

### 1.2.ブランチをGitHubにプッシュ
`git push origin ブランチ名(自分の名字)`

### 開発が終了するまで2~4繰り返し（定期的にプッシュする）

### 1.2.開発が完了したらプルリクエストを出す
**Compare & pull request**をクリック

**Merge pull requestボタンは押さない！！！**

### プッシュしない物

以下のファイルはプッシュできるがしないでほしい  

.idea/compiler.xml  
.idea/gradle.xml  
.idea/vcs.xml  
.idea/misc.xml  


#### 以下は必ずリーダーのみ行う
<details>
Merge pull requestボタンを押しmainブランチにマージ

Delete branchボタンを押し不要になったリモートブランチを削除
</details>

### 2.ローカルブランチを削除する
`git checkout main`

`git branch -D ブランチ名(自分の名前)`

### 3.ローカルのmainブランチをpullで更新
`git branch`

（mainブランチにいるか確認する）

`git pull origin main`


### 4.ブランチの作成


`git checkout -b ＜新しいブランチ名＞`



## GitHubコマンド打ちたくない方へ

### オプションは二つあります

#### 1  VSCodeのGithub Extensionをダウンロードしそこから作業する

#### 2  GitHub DesktopをインストールしそこからPull,pushのGitを操作する




### 1.1　Vscodeでやる人はここから

![img1](https://user-images.githubusercontent.com/50572505/119298062-38905a00-bc97-11eb-810a-87627aa79cf7.png)

 1ブランチの確認/変更
   
    左下の部分にブランチの確認と変更ができます


   ![img2](https://user-images.githubusercontent.com/50572505/119298469-10552b00-bc98-11eb-963c-dffc9fea2add.png)
   
    Create new branch...で新しいブランチを作成できます

 2 ChangeとStaged Change　
      
    ＋は変更や作ったものをStaged Changeにする（変更したものを確認したという意味）
    ↶は変更したものを前の状態に戻す（最後のコミット状態）

 3アイコン
      
    M は変更（既にある物を変更）
    A 新しく追加された（ファイル、写真が前のコミットに存在していない）


 4 コミットのコメントを入力する場所
    
    ・コミット名は　[]変更された部分の一言
    例　　　[Fix]ログインエラー   
           [Add]新規登録機能
    ルールではないが誰かが見ても理解できたらいい（各グループで話し合ってきめてもよし



  5 ✔をクリックするとStaged Changeされてる物をコミットする    

ここまでは***個人のPCです***GitHubにはまだアップロードしていません。

![スクリーンショット 2021-05-24 141003](https://user-images.githubusercontent.com/50572505/119299792-9d997f00-bc9a-11eb-9b84-29197b362321.png)

ここの🔄0↓1↑をクリックしない限りアップロードしませんのでご注文ください
    
    ↑　＝　アップロード
    ↓　＝　ダウンロード


これができたら完了です！


  


### 2.1　GitHub Desktopでやるかたこちら

### 1に戻る

