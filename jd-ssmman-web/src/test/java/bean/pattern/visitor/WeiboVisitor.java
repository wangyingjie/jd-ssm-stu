package bean.pattern.visitor;

/**
 * @desc
 * @author: wangyingjie1
 * @date: ${date}
 */
public class WeiboVisitor implements Visitor {

    @Override
    public void visit(Login login) {

        System.out.println("weibo visitor =============");

        login.accept(this);
    }
}
