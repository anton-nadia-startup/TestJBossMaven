package temp;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;
import temp.items.Item;
import temp.items.ItemImpl;
import temp.items.parameters.Activity;
import temp.items.parameters.Season;
import temp.items.parameters.StringParameter;
import temp.requests.RequestImpl;
import temp.utils.ItemsLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Anton Krupnov
 * Date: 30.08.13
 * Time: 23:23
 */
public class DroolsMain {
    public static void main(String[] args) {
        KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        builder.add(ResourceFactory.newClassPathResource("rules/Rules.drl", "UTF-8", DroolsMain.class), ResourceType.DRL);

        KnowledgeBase knowledgeBase = builder.newKnowledgeBase();
        StatelessKnowledgeSession session = knowledgeBase.newStatelessKnowledgeSession();

        List<Object> parameters = new ArrayList<Object>();
        parameters.addAll(new ItemsLoader().loadItems());
        parameters.add(new RequestImpl(
                new StringParameter("winter")));

        session.execute(parameters);
    }
}
