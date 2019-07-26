package com.gw.lambds.chart2;

/**
 * 〈〉函数式接口
 * create by zgw on 2019/7/26
 */
public interface Funcation<T,R> {
    R apply(T t);
}
/**
 * b. 若要编写一个计算器程序，你会使用该接口表示什么样的 Lambda 表达式？
 */
class  CaptureCompile{

    public  void  _a(){
        Funcation<Integer,Integer> res = (x) -> -1*x;
    }




}