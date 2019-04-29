package innerclasses3;

import innerclasses.SimpleInterface;
//在包外继承这个内部类，并且用方法返回内部类的一个对象，
//向上转型：内部类->接口
public class EX6 extends innerclasses2.EX6 {
    public SimpleInterface makeParcel() {
        return new SmallParcel();
    }
}
