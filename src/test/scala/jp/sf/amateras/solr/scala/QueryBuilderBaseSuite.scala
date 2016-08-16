package jp.sf.amateras.solr.scala

import org.scalatest.FunSuite
import jp.sf.amateras.solr.scala.query.DefaultExpressionParser

class QueryBuilderBaseSuite extends FunSuite {
  
  test("copy"){
    SolrServerFactory.dummy(request => ())
    implicit val parser = new DefaultExpressionParser()
    val queryBuilder = new TestQueryBuilder()
    val copied = queryBuilder.id("contentId")
                             .highlight("content", 200, "<b>", "</b>", 2)
                             .fq("something:cool")
    
    assert(copied.getId == "contentId")
    assert(copied.getHilightingField == "content")
    assert(copied.getQuery.getHighlight)
    assert(copied.getQuery.getHighlightFields.length == 1)
    assert(copied.getQuery.getHighlightFields()(0) == "content")
    assert(copied.getQuery.getHighlightSimplePre == "<b>")
    assert(copied.getQuery.getHighlightSimplePost == "</b>")
    assert(copied.getQuery.getHighlightSnippets == 2)
    assert(copied.getQuery.getFacetQuery.contains("something:cool"))
  }
  
  class TestQueryBuilder extends QueryBuilderBase[TestQueryBuilder]{
    protected def createCopy: TestQueryBuilder = new TestQueryBuilder()
    def getId = this.id
    def getQuery = this.solrQuery
    def getHilightingField = this.highlightField
  }
  

}