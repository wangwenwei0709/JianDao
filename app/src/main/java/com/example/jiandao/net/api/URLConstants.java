package com.example.jiandao.net.api;

public class URLConstants {
    public static String BASE_URL="https://www.seetao.com/";
    //推荐列表
    public static String RECOMMEND_LIST="app/v_1_3/article/recommendlist";
    //视频列表
    public static String VEDIO_LIST="app/v_1_3/article/videolist";

    //栏目列表
    public static String COLUMN_LIST="api/column/columnlist";

    //    手机验证码登录接口
    public static String LOGIN = "api/user/smslogin";


    //    获取验证码接口
    public static String SENDVERIFIED = "api/sms/sendsms";

    //    验证验证码是否正确
    public static String CHECKSMSCODE= "api/sms/checksmscode";

    //用户注册
    public static String REGISTER= "api/user/register";

    //密码邮箱登录
    public static String PASSWORDLOGIN= "api/user/login";

    //忘记密码
    public static String SAVEPASSWORD="app/v_1_1/user/savepassword";

    //专题列表
    public static String SPECIAL_LIST="app/v_1_3/article/speciallist";

    //获取跟本⽂章关联的⽂章列表
    public static String ARTICLEACCESS="api/article/articleaccess";

    //收藏和取消收藏
    public static String USERCOLLECT="api/article/usercollect";

    //⽂章是否被⽤户 点赞，点踩，收藏和⽂章相关信息
    public static String  ARTICLEATTRIBUTE="api/article/articleattribute";

    //获取文章评论列表
    public static String COMMENTLIST = "api/comment_reply/commentlist";

}
