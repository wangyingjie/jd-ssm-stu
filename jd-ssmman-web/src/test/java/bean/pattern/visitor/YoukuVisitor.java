package bean.pattern.visitor;

/**
 * @desc J.U.C = java.util.currenttZ
 * @author: wangyingjie1
 * @date: ${date}
 */
public class YoukuVisitor implements Visitor {


    @Override
    public void visit(Login login) {
        System.out.println("youku visitor =============");
        login.accept(this);
    }
}
