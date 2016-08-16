package jp.sf.amateras.solr.scala

import org.apache.solr.common.SolrInputDocument
import org.apache.solr.client.solrj.{SolrClient => ApacheSolrClient}

class BatchRegister(server: ApacheSolrClient, docs: Map[String, Any]*){

  add(docs: _*)

  def add(docs: Any*): BatchRegister = {
    CaseClassMapper.toMapArray(docs: _*).foreach { doc =>
      val solrDoc = new SolrInputDocument
      doc.foreach { case (key, value) =>
        solrDoc.addField(key, value)
      }
      server.add(solrDoc)
    }
    this
  }

  def commit(): Unit = server.commit

  def rollback(): Unit = server.rollback

}