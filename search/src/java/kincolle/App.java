package kincolle;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;
import java.io.StringReader;

/**
 * Hello world!
 *
 */
public class App{
    public static void main( String[] args ) throws IOException {
        stdAnalyzer("尴尬！这种房子比市场价低30% 却没啥人买");
        stdAnalyzer("Executing a GetRequest can also be done in an asynchronous fashion so that the client can return directly.");
    }

    public static void stdAnalyzer(String srt) throws IOException {
        Analyzer analyzer = null;
        analyzer= new StandardAnalyzer();
        StringReader reader = new StringReader(srt);
        TokenStream toStream = analyzer.tokenStream(srt,reader);


        toStream.reset();
        CharTermAttribute teAttribute = toStream.getAttribute(CharTermAttribute.class);
        System.out.println("分词结果：");
        while (toStream.incrementToken()){
            System.out.println(teAttribute.toString()+"|");
        }
        System.out.println("\n");
        analyzer.close();
    }
}