package com.example.jiandao.net;

public class NetWorkFactory {
//    制造产品
//    RetrfitUtils   、    HttpUrlConnettionUtils

//    如果设置1  表示使用retrofit请求方式
//    如果设置其他   表示用httpurl请求方式
    private static int NET_TYPE = 1;

    public INetWork netWork;

    private static NetWorkFactory netWorkFactory;

    public static NetWorkFactory getInstance() {
        if(netWorkFactory == null){
            synchronized (RetrofitUtils.class){
                if (netWorkFactory == null){
                    netWorkFactory = new NetWorkFactory();
                }
            }
        }
        return netWorkFactory;
    }

    public INetWork getNetWork(){
        if (NET_TYPE == 1){
            netWork = RetrofitUtils.getInstance();
        }else {
            netWork = HttpUrlConnetionUtils.getInstance();
        }
        return netWork;
    }
}
