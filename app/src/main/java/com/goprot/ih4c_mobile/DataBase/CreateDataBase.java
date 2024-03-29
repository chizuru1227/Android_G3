package com.goprot.ih4c_mobile.DataBase;

import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import com.goprot.ih4c_mobile.HttpRequest;
import com.goprot.ih4c_mobile.post_values.CreateChoicesValues;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CreateDataBase extends AppCompatActivity {
    //データベースを作成

    public static void  CreateDB(String dbStr) {
        SQLiteDatabase db;
        db = SQLiteDatabase.openOrCreateDatabase(dbStr,null);
        //テーブル作成用のクエリ文
        String quuery_table2 = "CREATE TABLE IF NOT EXISTS UNIT_TBL(id INTEGER PRIMARY KEY AUTOINCREMENT, subject_id TEXT, unit_id INTEGER, unit_name TEXT, grade_id INTEGER)";
        db.execSQL(quuery_table2);
        //テーブル削除クエリ文
        db.execSQL("delete from UNIT_TBL ");
        String query_record_set[] ={
//                国語
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 1, '漢字の読み書き', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 2, '成り立ちと部首', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 3, '書き順と画数', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 4, '文法の基本', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 5, '指示する語句', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 6, '接続する語句', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 7, '古文・漢文', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 8, '漢字の読みかき', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 9, '類義・対義・多義', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 10, '熟語', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 11, '敬語', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 12, '活用する自立語', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 13, '活用しない自立語', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 14, '活用する付属語', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 15, '活用しない付属語', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 16, '短歌', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 17, '古文・漢文', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 18, '漢字の読み書き', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 19, '漢語和語・外来語', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 20, '慣用句・ことわざ', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 21, '故事成語', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 22, '品詞の識別', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 23, '俳句', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 24, '古典の文法', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 25, '古典の読解', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 26, '和歌', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 27, '漢文の読解', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('NL', 28, '文学史', 3)",
//                数学
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 29, '正負の数', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 30, '加法と減法', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 31, '乗法と除法', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 32, '四則演算', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 33, '1次式', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 34, '数値の関係', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 35, '方程式', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 36, '不等式', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 37, '比例', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 38, '反比例', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 39, '平面図形', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 40, '円とおうぎ形', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 41, '三角形', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 42, '表面積と体積', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 43, '立方体の切り口', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 44, '資料の整理と活用', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 45, '近似値と有効数字', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 46, '式の計算', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 47, '文字式の利用', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 48, '連立方程式', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 49, '1次関数', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 50, '平行線と角', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 51, '合同と証明', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 52, '三角形', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 53, '四角形', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 54, '確率', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 55, 'データの活用', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 56, '式の展開', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 57, '因数分解', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 58, '平方根', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 59, '2次元方程式', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 60, '関数y=ax²', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 61, '関数の利用', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 62, '相似な図形', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 63, '平行線と線分の比', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 64, '三角形の重心', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 65, '円周角の定理', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 66, '三平方の定理', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('MT', 67, '標本調査', 3)",

                //社会　理科
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(68, '世界のすがた', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(69, '世界各地の暮らし', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(70, 'アジア州', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(71, 'ヨーロッパ州', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(72, '北アメリカ州', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(73, '南アメリカ州', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(74, 'アフリカ州', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(75, 'オセアニア州', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(76, '文明', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(77, '弥生～古墳時代', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(78, '飛鳥・奈良時代', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(79, '平安時代', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(80, '古代日本の文化', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(81, '鎌倉時代', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(82, '室町時代と中世', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(83, '大航海時代', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(84, '安土桃山時代', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(85, '江戸の政治と外交', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(86, '江戸の産業と文化', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(87, '日本の地形と気候', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(88, '日本の人口と産業', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(89, '九州・沖縄地方', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(90, '中国・四国地方', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(91, '近畿地方', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(92, '中部地方', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(93, '関東地方', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(94, '東北地方', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(95, '北海道地方', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(96, '江戸の政治改革', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(97, 'ヨーロッパの革命', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(98, '江戸幕府の滅亡', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(99, '明治政府', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(100, '文明開化', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(101, '憲法と議会', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(102, '日清・日露戦争', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(103, '第一次世界大戦', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(104, '世界恐慌と日中戦争', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(105, '第二次世界大戦', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(106, '民主化と国際社会', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(107, '冷戦と日本経済', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(108, '日本と世界の先', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(109, '現代社会の特色', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(110, '生活と文化', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(111, '現代社会の考え方', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(112, '憲法と基本原理', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(113, '人権の尊重と憲法', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(114, '民主政治の仕組み', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(115, '国の政治の仕組み', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(116, '地方自治', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(117, '消費と市場経済', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(118, '金融と日本経済', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(119, '財政と国民の福祉', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(120, '国際社会と平和', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(121, '国際社会の課題', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(122, '身近な生物の観察', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(123, '花', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(124, '根と茎', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(125, '葉', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(126, '植物の分類', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(127, '動物の分類', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(128, '物質の性質', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(129, '気体の性質', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(130, '水溶液の性質', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(131, '物質の状態変化', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(132, '光の性質', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(133, '音の性質', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(134, '力と圧力', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(135, '火山活動と火成岩', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(136, '地震と大地の変動', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(137, '地層と歴史', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(138, '物質の成り立ち', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(139, '化学変化', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(140, '化学変化と質量', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(141, '生物と細胞', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(142, '臓器', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(143, '神経と感覚の構造', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(144, '動物の分類', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(145, '生物の変異と進化', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(146, '気象の観測', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(147, '空気中の水', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(148, '前線と天気', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(149, '大気と日本の天気', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(150, '電気の性質', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(151, '静電気と電流', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(152, '電流と磁界', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(153, '水溶液とイオン', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(154, '酸・アルカリ', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(155, '生物の成長と繁殖', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(156, '遺伝と遺伝子', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(157, '力のつり合い', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(158, '物体の運動', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(159, '仕事とエネルギー', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(160, '太陽系天体と宇宙', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(161, '地球の運動と天体', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(162, '月と惑星の関係', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(163, '自然界のつながり', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(164, '技術と人間', 'SE', 3)",


//                英語
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 165, 'be動詞', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 166, '複数形と数', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 167, '疑問詞', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 168, '一般動詞', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 169, '冠詞', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 170, '形容詞と副詞', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 171, '接続詞', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 172, '数や量の表し方', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 173, '感嘆表現', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 174, '一般動詞の連語', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 175, '命令文', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 176, '現在進行形', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 177, 'can', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 178, '前置詞', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 179, '代名詞', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 180, '序数', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 181, '時間・日付', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 182, '一般動詞の過去形', 1)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 183, '文の構造', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 184, 'be動詞', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 185, 'be動詞の過去形', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 186, 'be動詞過去進行形', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 187, '一般動詞の連語', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 188, '数や量の表し方', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 189, 'will', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 190, 'must・may', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 191, 'その他の助動詞', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 192, '助動詞の表現', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 193, '接続詞', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 194, '前置詞', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 195, '前置詞の連語', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 196, '代名詞', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 197, '不定詞', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 198, '動名詞', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 199, '比較', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 200, '受け身の文', 2)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 201, '現在完了', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 202, '接続詞', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 203, '再帰代名詞', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 204, '不定詞', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 205, '修飾する分詞', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 206, '関係代名詞', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 207, '関接疑問', 3)",
                "INSERT INTO UNIT_TBL(subject_id, unit_id,unit_name,grade_id)VALUES('EL', 208, '連語', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(68, '世界のすがた', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(69, '世界各地の暮らし', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(70, 'アジア州', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(71, 'ヨーロッパ州', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(72, '北アメリカ州', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(73, '南アメリカ州', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(74, 'アフリカ州', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(75, 'オセアニア州', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(76, '文明', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(77, '弥生～古墳時代', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(78, '飛鳥・奈良時代', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(79, '平安時代', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(80, '古代日本の文化', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(81, '鎌倉時代', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(82, '室町時代と中世', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(83, '大航海時代', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(84, '安土桃山時代', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(85, '江戸の政治と外交', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(86, '江戸の産業と文化', 'SS', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(87, '日本の地形と気候', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(88, '日本の人口と産業', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(89, '九州・沖縄地方', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(90, '中国・四国地方', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(91, '近畿地方', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(92, '中部地方', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(93, '関東地方', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(94, '東北地方', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(95, '北海道地方', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(96, '江戸の政治改革', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(97, 'ヨーロッパの革命', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(98, '江戸幕府の滅亡', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(99, '明治政府', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(100, '文明開化', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(101, '憲法と議会', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(102, '日清・日露戦争', 'SS', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(103, '第一次世界大戦', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(104, '世界恐慌と日中戦争', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(105, '第二次世界大戦', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(106, '民主化と国際社会', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(107, '冷戦と日本経済', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(108, '日本と世界の先', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(109, '現代社会の特色', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(110, '生活と文化', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(111, '現代社会の考え方', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(112, '憲法と基本原理', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(113, '人権の尊重と憲法', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(114, '民主政治の仕組み', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(115, '国の政治の仕組み', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(116, '地方自治', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(117, '消費と市場経済', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(118, '金融と日本経済', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(119, '財政と国民の福祉', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(120, '国際社会と平和', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(121, '国際社会の課題', 'SS', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(122, '身近な生物の観察', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(123, '花', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(124, '根と茎', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(125, '葉', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(126, '植物の分類', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(127, '動物の分類', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(128, '物質の性質', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(129, '気体の性質', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(130, '水溶液の性質', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(131, '物質の状態変化', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(132, '光の性質', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(133, '音の性質', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(134, '力と圧力', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(135, '火山活動と火成岩', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(136, '地震と大地の変動', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(137, '地層と歴史', 'SE', 1)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(138, '物質の成り立ち', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(139, '化学変化', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(140, '化学変化と質量', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(141, '生物と細胞', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(142, '臓器', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(143, '神経と感覚の構造', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(144, '動物の分類', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(145, '生物の変異と進化', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(146, '気象の観測', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(147, '空気中の水', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(148, '前線と天気', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(149, '大気と日本の天気', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(150, '電気の性質', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(151, '静電気と電流', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(152, '電流と磁界', 'SE', 2)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(153, '水溶液とイオン', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(154, '酸・アルカリ', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(155, '生物の成長と繁殖', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(156, '遺伝と遺伝子', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(157, '力のつり合い', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(158, '物体の運動', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(159, '仕事とエネルギー', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(160, '太陽系天体と宇宙', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(161, '地球の運動と天体', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(162, '月と惑星の関係', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(163, '自然界のつながり', 'SE', 3)",
                "INSERT INTO UNIT_TBL(unit_id,unit_name,subject_id,grade_id)VALUES(164, '技術と人間', 'SE', 3)"
        };
        for (int i=0;i<query_record_set.length;i++){
            db.execSQL(query_record_set[i]);
        }




    }







}






