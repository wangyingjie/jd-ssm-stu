package bean.pattern.visitor;

/**
 * @desc
 * @author: wangyingjie1
 * @date: ${date}
 */
public interface Login {

    /**
     * 登录接收 访问者，具体哪个访问者不关心
     *
     * @param visitor
     */
    void  accept(Visitor visitor);
}
