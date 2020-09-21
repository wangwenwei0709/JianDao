package com.example.jiandao.details.bean;

import com.example.jiandao.witgth.CommentsView;

import java.util.List;

public class CommentBean {
    @Override
    public String toString() {
        return "CommentBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 1
     * message : 操作成功
     * data : {"start":"0","point_time":1589446341,"more":0,"comment_list":[{"comment_id":"741","type":1,"reply_id":0,"user_id":"266","content":"3","username":"安详的夕阳","head_url":"https://www.seetao.com/Public/static/default_head.jpeg","time_describe":"2分钟前","praise_count_describe":"0","is_praise":0,"reply_start":0,"reply_more":0,"reply_list":[]},{"comment_id":"740","type":1,"reply_id":0,"user_id":"266","content":"2","username":"安详的夕阳","head_url":"https://www.seetao.com/Public/static/default_head.jpeg","time_describe":"2分钟前","praise_count_describe":"0","is_praise":0,"reply_start":0,"reply_more":0,"reply_list":[]},{"comment_id":"739","type":1,"reply_id":0,"user_id":"266","content":"1","username":"安详的夕阳","head_url":"https://www.seetao.com/Public/static/default_head.jpeg","time_describe":"2分钟前","praise_count_describe":"0","is_praise":0,"reply_start":0,"reply_more":0,"reply_list":[]},{"comment_id":"737","type":1,"reply_id":0,"user_id":"266","content":"厉害吗","username":"安详的夕阳","head_url":"https://www.seetao.com/Public/static/default_head.jpeg","time_describe":"3分钟前","praise_count_describe":"0","is_praise":0,"reply_start":0,"reply_more":0,"reply_list":[]},{"comment_id":"736","type":1,"reply_id":0,"user_id":"266","content":"这个更厉害","username":"安详的夕阳","head_url":"https://www.seetao.com/Public/static/default_head.jpeg","time_describe":"3分钟前","praise_count_describe":"0","is_praise":0,"reply_start":0,"reply_more":0,"reply_list":[]},{"comment_id":"735","type":1,"reply_id":0,"user_id":"262","content":"...","username":"冷静的鸡翅","head_url":"https://www.seetao.com/Public/static/default_head.jpeg","time_describe":"4分钟前","praise_count_describe":"0","is_praise":0,"reply_start":0,"reply_more":0,"reply_list":[{"reply_id":"426","type":2,"comment_id":"735","content":"123","from_name":"大胆的手机","to_name":"冷静的鸡翅","from_id":"272","to_id":"262"}]},{"comment_id":"734","type":1,"reply_id":0,"user_id":"272","content":"这个厉害","username":"大胆的手机","head_url":"https://www.seetao.com/Public/static/default_head.jpeg","time_describe":"4分钟前","praise_count_describe":"0","is_praise":0,"reply_start":0,"reply_more":0,"reply_list":[{"reply_id":"425","type":2,"comment_id":"734","content":"111222333","from_name":"安详的夕阳","to_name":"大胆的手机","from_id":"266","to_id":"272"},{"reply_id":"424","type":2,"comment_id":"734","content":"我给你多刷几条哈哈哈","from_name":"安详的夕阳","to_name":"大胆的手机","from_id":"266","to_id":"272"},{"reply_id":"423","type":2,"comment_id":"734","content":"哈哈哈","from_name":"安详的夕阳","to_name":"大胆的手机","from_id":"266","to_id":"272"}]}]}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "start='" + start + '\'' +
                    ", point_time=" + point_time +
                    ", more=" + more +
                    ", comment_list=" + comment_list +
                    '}';
        }

        /**
         * start : 0
         * point_time : 1589446341
         * more : 0
         * comment_list : [{"comment_id":"741","type":1,"reply_id":0,"user_id":"266","content":"3","username":"安详的夕阳","head_url":"https://www.seetao.com/Public/static/default_head.jpeg","time_describe":"2分钟前","praise_count_describe":"0","is_praise":0,"reply_start":0,"reply_more":0,"reply_list":[]},{"comment_id":"740","type":1,"reply_id":0,"user_id":"266","content":"2","username":"安详的夕阳","head_url":"https://www.seetao.com/Public/static/default_head.jpeg","time_describe":"2分钟前","praise_count_describe":"0","is_praise":0,"reply_start":0,"reply_more":0,"reply_list":[]},{"comment_id":"739","type":1,"reply_id":0,"user_id":"266","content":"1","username":"安详的夕阳","head_url":"https://www.seetao.com/Public/static/default_head.jpeg","time_describe":"2分钟前","praise_count_describe":"0","is_praise":0,"reply_start":0,"reply_more":0,"reply_list":[]},{"comment_id":"737","type":1,"reply_id":0,"user_id":"266","content":"厉害吗","username":"安详的夕阳","head_url":"https://www.seetao.com/Public/static/default_head.jpeg","time_describe":"3分钟前","praise_count_describe":"0","is_praise":0,"reply_start":0,"reply_more":0,"reply_list":[]},{"comment_id":"736","type":1,"reply_id":0,"user_id":"266","content":"这个更厉害","username":"安详的夕阳","head_url":"https://www.seetao.com/Public/static/default_head.jpeg","time_describe":"3分钟前","praise_count_describe":"0","is_praise":0,"reply_start":0,"reply_more":0,"reply_list":[]},{"comment_id":"735","type":1,"reply_id":0,"user_id":"262","content":"...","username":"冷静的鸡翅","head_url":"https://www.seetao.com/Public/static/default_head.jpeg","time_describe":"4分钟前","praise_count_describe":"0","is_praise":0,"reply_start":0,"reply_more":0,"reply_list":[{"reply_id":"426","type":2,"comment_id":"735","content":"123","from_name":"大胆的手机","to_name":"冷静的鸡翅","from_id":"272","to_id":"262"}]},{"comment_id":"734","type":1,"reply_id":0,"user_id":"272","content":"这个厉害","username":"大胆的手机","head_url":"https://www.seetao.com/Public/static/default_head.jpeg","time_describe":"4分钟前","praise_count_describe":"0","is_praise":0,"reply_start":0,"reply_more":0,"reply_list":[{"reply_id":"425","type":2,"comment_id":"734","content":"111222333","from_name":"安详的夕阳","to_name":"大胆的手机","from_id":"266","to_id":"272"},{"reply_id":"424","type":2,"comment_id":"734","content":"我给你多刷几条哈哈哈","from_name":"安详的夕阳","to_name":"大胆的手机","from_id":"266","to_id":"272"},{"reply_id":"423","type":2,"comment_id":"734","content":"哈哈哈","from_name":"安详的夕阳","to_name":"大胆的手机","from_id":"266","to_id":"272"}]}]
         */

        private String start;
        private int point_time;
        private int more;
        private List<CommentListBean> comment_list;

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public int getPoint_time() {
            return point_time;
        }

        public void setPoint_time(int point_time) {
            this.point_time = point_time;
        }

        public int getMore() {
            return more;
        }

        public void setMore(int more) {
            this.more = more;
        }

        public List<CommentListBean> getComment_list() {
            return comment_list;
        }

        public void setComment_list(List<CommentListBean> comment_list) {
            this.comment_list = comment_list;
        }




        public static class CommentListBean {
            @Override
            public String toString() {
                return "CommentListBean{" +
                        "comment_id='" + comment_id + '\'' +
                        ", type=" + type +
                        ", reply_id=" + reply_id +
                        ", user_id='" + user_id + '\'' +
                        ", content='" + content + '\'' +
                        ", username='" + username + '\'' +
                        ", head_url='" + head_url + '\'' +
                        ", time_describe='" + time_describe + '\'' +
                        ", praise_count_describe='" + praise_count_describe + '\'' +
                        ", is_praise=" + is_praise +
                        ", reply_start=" + reply_start +
                        ", reply_more=" + reply_more +
                        ", reply_list=" + reply_list +
                        '}';
            }

            /**
             * comment_id : 741
             * type : 1
             * reply_id : 0
             * user_id : 266
             * content : 3
             * username : 安详的夕阳
             * head_url : https://www.seetao.com/Public/static/default_head.jpeg
             * time_describe : 2分钟前
             * praise_count_describe : 0
             * is_praise : 0
             * reply_start : 0
             * reply_more : 0
             * reply_list : []
             */

            private String comment_id;
            private int type;
            private int reply_id;
            private String user_id;
            private String content;
            private String username;
            private String head_url;
            private String time_describe;
            private String praise_count_describe;
            private int is_praise;
            private int reply_start;
            private int reply_more;
            private List<Reply> reply_list;

            public static class Reply implements CommentsView.ReplayData {
                @Override
                public String toString() {
                    return "Reply{" +
                            "reply_id=" + reply_id +
                            ", type=" + type +
                            ", comment_id=" + comment_id +
                            ", content=" + content +
                            ", from_name='" + from_name + '\'' +
                            ", to_name='" + to_name + '\'' +
                            ", from_id='" + from_id + '\'' +
                            ", to_id='" + to_id + '\'' +
                            '}';
                }

                private String reply_id;
                private String type;
                private String comment_id;
                private String content;
                private String from_name;
                private String to_name;
                private String  from_id;
                private String  to_id;

                public String getReply_id() {
                    return reply_id;
                }

                public void setReply_id(String reply_id) {
                    this.reply_id = reply_id;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getComment_id() {
                    return comment_id;
                }

                public void setComment_id(String comment_id) {
                    this.comment_id = comment_id;
                }

                @Override
                public String getFromUserName() {
                    return getFrom_name();
                }

                @Override
                public String getToUserName() {
                    return getToUserName();
                }
                @Override
                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getFrom_name() {
                    return from_name;
                }

                public void setFrom_name(String from_name) {
                    this.from_name = from_name;
                }

                public String getTo_name() {
                    return to_name;
                }

                public void setTo_name(String to_name) {
                    this.to_name = to_name;
                }

                public String getFrom_id() {
                    return from_id;
                }

                public void setFrom_id(String from_id) {
                    this.from_id = from_id;
                }

                public String getTo_id() {
                    return to_id;
                }

                public void setTo_id(String to_id) {
                    this.to_id = to_id;
                }
            }



            public String getComment_id() {
                return comment_id;
            }

            public void setComment_id(String comment_id) {
                this.comment_id = comment_id;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getReply_id() {
                return reply_id;
            }

            public void setReply_id(int reply_id) {
                this.reply_id = reply_id;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getHead_url() {
                return head_url;
            }

            public void setHead_url(String head_url) {
                this.head_url = head_url;
            }

            public String getTime_describe() {
                return time_describe;
            }

            public void setTime_describe(String time_describe) {
                this.time_describe = time_describe;
            }

            public String getPraise_count_describe() {
                return praise_count_describe;
            }

            public void setPraise_count_describe(String praise_count_describe) {
                this.praise_count_describe = praise_count_describe;
            }

            public int getIs_praise() {
                return is_praise;
            }

            public void setIs_praise(int is_praise) {
                this.is_praise = is_praise;
            }

            public int getReply_start() {
                return reply_start;
            }

            public void setReply_start(int reply_start) {
                this.reply_start = reply_start;
            }

            public int getReply_more() {
                return reply_more;
            }

            public void setReply_more(int reply_more) {
                this.reply_more = reply_more;
            }

            public List<Reply> getReply_list() {
                return reply_list;
            }

            public void setReply_list(List<Reply> reply_list) {
                this.reply_list = reply_list;
            }
        }
    }




}
