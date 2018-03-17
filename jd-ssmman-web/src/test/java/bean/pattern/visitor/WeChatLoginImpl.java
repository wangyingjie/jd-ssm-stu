package bean.pattern.visitor;

/**
 * @desc
 * @author: wangyingjie1
 * @date: ${date}
 */
public class WeChatLoginImpl implements Login {

    @Override
    public void accept(Visitor visitor) {

        System.out.println("we chat login visit i qi yi===== " + visitor.getClass().getSimpleName());
    }
}
