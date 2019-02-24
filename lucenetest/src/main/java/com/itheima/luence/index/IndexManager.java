package com.itheima.luence.index;

import com.itheima.luence.Book;
import com.itheima.luence.dao.impl.BookDaoImpl;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexManager {
             @Test
          public void createIndex() throws Exception{
              BookDaoImpl bookDao = new BookDaoImpl();
              List<Book> books = bookDao.findAll();
              ArrayList<Document> documents = new ArrayList<>();
              for (Book book : books) {
                  Document document = new Document();
                  document.add(new StringField("id",book.getId()+"", Field.Store.YES));
                  document.add(new TextField("bookName",book.getBookName()+"", Field.Store.YES));
                  document.add(new DoubleField("bookPrice",book.getPrice() ,Field.Store.YES));
                  document.add(new StoredField("bookPic",book.getPic()));
                  document.add(new TextField("bookDesc",book.getBookDesc()+"", Field.Store.NO));
                  documents.add(document);
              }
              Analyzer analyzer = new IKAnalyzer();
              IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
                 indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
              Directory directory = FSDirectory.open(new File("D:\\index"));
              IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
              for (Document document : documents) {
                  indexWriter.addDocument(document);
              }
              indexWriter.commit();
              indexWriter.close();
          }
/*
* 1.新建分词器
* 2.新建查询解析器对象
* 3.执行查询解析
* 4.创建索引库存储目录
* 5.新建indexReader 读取索引库对象
* 6.新建索引查询对象,执行搜索索引库
* */
        @Test
          public void searchIndex() throws Exception {
            Analyzer analyzer = new IKAnalyzer();
            //新建查询解析器对象
              QueryParser queryParser = new QueryParser("bookName",analyzer);
              Query query = queryParser.parse("bookName:java");
              Directory directory = FSDirectory.open(new File("D:\\index1"));
              IndexReader indexReader = DirectoryReader.open(directory);
              IndexSearcher indexSearcher = new IndexSearcher(indexReader);
              TopDocs topDocs = indexSearcher.search(query, 10);
              System.out.println("总命中的记录数: "+topDocs.totalHits);
              ScoreDoc[] scoreDocs = topDocs.scoreDocs;
              for (ScoreDoc scoreDoc : scoreDocs) {
                  System.out.println("-----华丽分割线---");
                  System.out.println("文档Id:"+scoreDoc.doc+"文档分值:"+scoreDoc.score);
                  Document doc = indexSearcher.doc(scoreDoc.doc);
                  System.out.println("图书Id：" + doc.get("id"));
                  System.out.println("图书名称：" + doc.get("bookName"));
                  System.out.println("图书价格：" + doc.get("bookPrice"));
                  System.out.println("图书图片：" + doc.get("bookPic"));
                  System.out.println("图书描述：" + doc.get("bookDesc"));
              }
              indexReader.close();
          }
            @Test
          public void deleteIndexByTerm() throws IOException {
                Analyzer analyzer = new IKAnalyzer();
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
              FSDirectory directory = FSDirectory.open(new File("D:\\index"));
              IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
                Term term = new Term("bookName","java");
              indexWriter.deleteDocuments(term);
              indexWriter.close();
          }
            @Test
          public void deleteAllIndex()throws Exception{
              Analyzer analyzer = new IKAnalyzer();
              IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
              FSDirectory directory = FSDirectory.open(new File("D:\\index"));
              IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
              indexWriter.deleteAll();
              indexWriter.close();
          }
                @Test
          public void updateIndex()throws Exception{
              Analyzer analyzer = new IKAnalyzer();
              IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
              FSDirectory directory = FSDirectory.open(new File("D:\\index"));
              IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
              Document doc = new Document();
              doc.add(new StringField("id","9529", Field.Store.YES));
              doc.add(new TextField("name","luence solr dubbo zookeeper", Field.Store.YES));
              Term term = new Term("name","lucene");
              indexWriter.updateDocument(term, doc);
              indexWriter.commit();
              indexWriter.close();
          }
            //定义搜寻方法
          private void search(Query query) throws IOException {
            //查询语法
              System.out.println("查询语法: "+ query);
              //创建索引库存储目录
              Directory directory = FSDirectory.open(new File("D:\\index"));
              IndexReader indexReader = DirectoryReader.open(directory);
              IndexSearcher indexSearcher = new IndexSearcher(indexReader);
              TopDocs topDocs = indexSearcher.search(query, 10);
              System.out.println("总命中的记录数: "+topDocs.totalHits);
              ScoreDoc[] scoreDocs = topDocs.scoreDocs;
              for (ScoreDoc scoreDoc : scoreDocs) {
                  System.out.println("-------华丽分割线----------");
                  System.out.println("文档 id: " + scoreDoc.doc
                          + "\t 文档分值：" + scoreDoc.score);
                   // 根据文档 id 获取指定的文档
                  Document doc = indexSearcher.doc(scoreDoc.doc);
                  System.out.println("图书 Id：" + doc.get("id"));
                  System.out.println("图书名称：" + doc.get("bookName"));
                  System.out.println("图书价格：" + doc.get("bookPrice"));
                  System.out.println("图书图片：" + doc.get("bookPic"));
                  System.out.println("图书描述：" + doc.get("bookDesc"));
              }
              indexReader.close();
              }

              /*
              * TermQuery 关键词查询
              *需求:查询图书名称域中包含有java的图书
              * */
                @Test
              public void testTermQuery() throws IOException {
                  //创建查询对象
                  TermQuery q = new TermQuery(new Term("bookName","java"));
                  //执行搜索
                  search(q);
              }
                @Test
              public void testNumericRangeQuery() throws IOException {
                    //创建查询对象
                  /*
                  * 参数说明
                  * field :域 的名称
                  * min:最小范围边界值
                  * max:最大范围边界值
                  * minInclusive:是否包含最小边界值
                  * maxInclusive:是否包含最大边界值
                  * */
                  //String field, Double min, Double max, boolean minInclusive, boolean maxInclusive
         Query   q = NumericRangeQuery.newDoubleRange("bookPrice",80d ,100d ,false ,false);
            search(q);
              }
                @Test
              public void testBooleanQuery() throws IOException {
                    TermQuery query1 = new TermQuery(new Term("bookName:java"));
                    Query query2 = NumericRangeQuery.newDoubleRange("bookPrice", 80d, 100d, true, true);
                        BooleanQuery q = new BooleanQuery();
                        q.add(query1, BooleanClause.Occur.MUST);
                        q.add(query2, BooleanClause.Occur.MUST);
                        search(q);
              }
                @Test
                public void testQueryParser() throws Exception {
                    //创建分析器,用于分词
                    Analyzer analyzer = new IKAnalyzer();
                    QueryParser queryParser = new QueryParser("bookName:java",analyzer);
                    Query query = queryParser.parse("bookName:java NOT bookName:lucene");
                    search(query);
                }

          }

