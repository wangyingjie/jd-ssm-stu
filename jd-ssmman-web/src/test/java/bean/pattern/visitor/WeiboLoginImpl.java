package bean.pattern.visitor;

/**
 * @desc
 * @author: wangyingjie1
 * @date: ${date}
 */
public class WeiboLoginImpl implements Login {

    @Override
    public void accept(Visitor visitor) {
        System.out.println("wei bo login visit======" + visitor.getClass().getSimpleName());
    }
}
