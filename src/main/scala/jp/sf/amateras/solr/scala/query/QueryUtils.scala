package jp.sf.amateras.solr.scala.query;

object QueryUtils {
  
  private lazy val specialCharacters =
    Set('+', '-', '&', '|',  '!', '(', ')', '{', '}', '[', ']', '^', '"', '~', '*', '?', ':')

  /**
   * Escapes special characters in the solr query.
   *
   * @param value the source string
   * @return the escaped string
   */
  def escape(value: String): String =
    value.toString.flatMap {
      case '\\' => Seq('\\', '\\')
      case c if specialCharacters.contains(c) => Seq('\\', c)
      case c => Seq(c)
    }.mkString
    
}
