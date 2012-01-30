■履歴
version 0.9.0 2010/01/31 プロトタイプ作成
version 0.9.1 2012/01/30 テンプレートエンジン機能に移行

■できること
dataディレクトリに設置したテーブルの定義からPOJOなEntityとDaoを生成する。
しかし、PreparedStatement句におけるget/setが不具合あり。

■実行本体（javaアプリ）
gen.accessdb.Creater param1 param2

■起動パラメータ
必須です。
param1・・・フォーマットに記載されたテーブルデータを格納するルートディレクトリ
param2・・・出力するフォルダ。パッケージ階層でディレクトリも出力

■クラスパス設定
○jarファイル
/CreateEntityDAO/lib/antlr-2.7.5.jar
/CreateEntityDAO/lib/avalon-logkit-2.1.jar
/CreateEntityDAO/lib/commons-collections-3.2.1.jar
/CreateEntityDAO/lib/commons-lang-2.4.jar
/CreateEntityDAO/lib/commons-logging-1.1.jar
/CreateEntityDAO/lib/jdom-1.0.jar
/CreateEntityDAO/lib/log4j-1.2.12.jar
/CreateEntityDAO/lib/maven-ant-tasks-2.0.9.jar
/CreateEntityDAO/lib/oro-2.0.8.jar
/CreateEntityDAO/lib/poi-3.6-20091214.jar
/CreateEntityDAO/lib/servletapi-2.3.jar
/CreateEntityDAO/lib/velocity-1.7.jar
/CreateEntityDAO/lib/werken-xpath-0.9.4.jar
confディレクトリ

■プロパティファイル
○名前
db.properties
○キー名と値
jdbc.class=JDBCのドライバークラス名
db.uri=DBアクセスのURI
db.user=DBユーザ
db.password=DBパスワード
例）
jdbc.class=org.gjt.mm.mysql.Driver
db.uri=jdbc:mysql://localhost:3306/hash
db.user=root
db.password=

■エクセルフォーマット
以下のセルに値が入っていれば書式などはなんでも問題なし。
○ファイル名
*.xls
○必須
A2・・・テーブル名（半角英数字）
B2・・・パッケージ名（最後にドットを含まないこと）
B5・・・列物理名（これ以降のB6、B7、B8…に列物理名を記述）
F5・・・Javaクラスにおけるエンティティ内クラス（これ以降のF6、F7、F8…に列物理名を記述）
○任意
A5・・・カラム名称。コメントになる。（これ以降のA6、A7、A8…にカラム名称を記述）
C5・・・主キー項目。「○」をする。（これ以降のC6、C7、C8…に主キー項目をチェック）
D6・・・データベースの列定義型。現在は使用していない。（これ以降のD6、D7、D8…にデータベースの列定義型を記述）
E6・・・データベースの列桁数。現在は使用していない。（これ以降のE6、E7、E8…にデータベースの列桁数を記述）

■対応予定の機能
PreparedStatement句におけるget/setの型対応。
テーブル定義型からJavaクラス自動出力機能。

