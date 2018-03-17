package bean.pattern.visitor;

/**
 * @desc
 * @author: wangyingjie1
 * @date: ${date}
 */
public class VisitorDemo {

    public static void main(String[] args) {
        Visitor visitor = new WeiboVisitor();
        Login chatLogin = new WeChatLoginImpl();
        Login weiboLogin = new WeiboLoginImpl();
        // visitor.visit(chatLogin);
        visitor.visit(weiboLogin);

    }
}
