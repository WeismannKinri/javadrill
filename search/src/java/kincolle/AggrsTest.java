package kincolle;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.grouping.*;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.Version;

import java.io.IOException;


public class AggrsTest {
    public static void main(String[] args) {
    }
    public void group(IndexSearcher indexSearcher, String groupField, String content) throws IOException, ParseException {
        GroupingSearch groupingSearch = new GroupingSearch(groupField);
        groupingSearch.setGroupSort(new Sort(SortField.FIELD_SCORE));
//        groupingSearch.setFillSortFields(true);
        groupingSearch.setCachingInMB(4.0, true);
        groupingSearch.setAllGroups(true);
        //groupingSearch.setAllGroupHeads(true);
        groupingSearch.setGroupDocsLimit(10);

        Query query = new TermQuery(new Term("",""));

        TopGroups<BytesRef> result = groupingSearch.search(indexSearcher, query, 0, 1000);

        System.out.println("搜索命中数：" + result.totalHitCount);
        System.out.println("搜索结果分组数：" + result.groups.length);

        Document document;
        for (GroupDocs<BytesRef> groupDocs : result.groups) {
            System.out.println("分组：" + groupDocs.groupValue.utf8ToString());
            System.out.println("组内记录：" + groupDocs.totalHits);

            //System.out.println("groupDocs.scoreDocs.length:" + groupDocs.scoreDocs.length);
            for (ScoreDoc scoreDoc : groupDocs.scoreDocs) {
                System.out.println(indexSearcher.doc(scoreDoc.doc));
            }
        }
    }


}
