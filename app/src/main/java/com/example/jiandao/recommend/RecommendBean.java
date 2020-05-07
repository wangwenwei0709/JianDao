package com.example.jiandao.recommend;

import java.util.List;

public class RecommendBean {
    @Override
    public String toString() {
        return "RecommendBean{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    /**
     * code : 1
     * data : {"article_list":[{"column_name":"栏⽬分类","content":"⽂章内容","description":"⽂章描述","edit_time":"⽂章发布时间","id":"⽂章id","image_url":"⽂章预览图","is_collect":"是否收藏，1已收藏，0未收藏","is_good":"是否点赞，1已点赞，0未点赞","lead":"导语","link":"⽂章链接","share_link":"⽂章分享链接","theme":"⽂章标题","type":"⽂章类型：1新闻，2快讯，3图⽚，4视频，5期刊，6专题,7⼴告","video_is_sans_href":"视频是否为外链，1是外链，0不是外链(type是视频时出现)","video_url":"视频链接地址(type是视频时出现)","view_type":"视图类型：1左图，2中间⼤图，3右图，4视频，5即时"},{"ad":{"ad_url":"⼴告资源url","height":"⼴告⾼度，单位px(视频时为0)","id":"⼴告id","layout":"APP⼴告布局:1图⽚开屏，2视频开屏，3图⽚通屏，4图⽚⽆标题，5图⽚有 标题，6视频⽆标题，7视频有标题，8图⽚栏⽬插屏","target_href":"点击⼴告打开的链接","title":"⼴告标题","width":"⼴告宽度，单位px(视频时为0)"},"type":"⽂章类型：1新闻，2快讯，3图⽚，4视频，5期刊，6专题，7⼴告"}],"banner_list":[{"description":"⽂章描述","id":"⽂章id","image_url":"⽂章预览图","is_collect":"是否收藏，1已收藏，0未收藏","is_good":"是否点赞，1已点赞，0未点赞","link":"⽂章链接","share_link":"⽂章分享链接","theme":"⽂章标题"}],"flash_id":"即时id","flash_list":[{"description":"⽂章描述","id":"⽂章id","is_collect":"是否收藏，1已收藏，0未收藏","is_good":"是否点赞，1已点赞，0未点赞","link":"⽂章链接","share_link":"⽂章分享链接","theme":"⽂章标题"}],"more":"是否有更多数据，1有，0没有","number":"下次请求⽂章次数","point_time":"下次请求使⽤的节点时间","start":"下次请求⽂章开始位置"}
     * message : 成功提示
     */

    private String code;
    private DataBean data;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "flash_id='" + flash_id + '\'' +
                    ", more='" + more + '\'' +
                    ", number='" + number + '\'' +
                    ", point_time='" + point_time + '\'' +
                    ", start='" + start + '\'' +
                    ", article_list=" + article_list +
                    ", banner_list=" + banner_list +
                    ", flash_list=" + flash_list +
                    '}';
        }

        /**
         * article_list : [{"column_name":"栏⽬分类","content":"⽂章内容","description":"⽂章描述","edit_time":"⽂章发布时间","id":"⽂章id","image_url":"⽂章预览图","is_collect":"是否收藏，1已收藏，0未收藏","is_good":"是否点赞，1已点赞，0未点赞","lead":"导语","link":"⽂章链接","share_link":"⽂章分享链接","theme":"⽂章标题","type":"⽂章类型：1新闻，2快讯，3图⽚，4视频，5期刊，6专题,7⼴告","video_is_sans_href":"视频是否为外链，1是外链，0不是外链(type是视频时出现)","video_url":"视频链接地址(type是视频时出现)","view_type":"视图类型：1左图，2中间⼤图，3右图，4视频，5即时"},{"ad":{"ad_url":"⼴告资源url","height":"⼴告⾼度，单位px(视频时为0)","id":"⼴告id","layout":"APP⼴告布局:1图⽚开屏，2视频开屏，3图⽚通屏，4图⽚⽆标题，5图⽚有 标题，6视频⽆标题，7视频有标题，8图⽚栏⽬插屏","target_href":"点击⼴告打开的链接","title":"⼴告标题","width":"⼴告宽度，单位px(视频时为0)"},"type":"⽂章类型：1新闻，2快讯，3图⽚，4视频，5期刊，6专题，7⼴告"}]
         * banner_list : [{"description":"⽂章描述","id":"⽂章id","image_url":"⽂章预览图","is_collect":"是否收藏，1已收藏，0未收藏","is_good":"是否点赞，1已点赞，0未点赞","link":"⽂章链接","share_link":"⽂章分享链接","theme":"⽂章标题"}]
         * flash_id : 即时id
         * flash_list : [{"description":"⽂章描述","id":"⽂章id","is_collect":"是否收藏，1已收藏，0未收藏","is_good":"是否点赞，1已点赞，0未点赞","link":"⽂章链接","share_link":"⽂章分享链接","theme":"⽂章标题"}]
         * more : 是否有更多数据，1有，0没有
         * number : 下次请求⽂章次数
         * point_time : 下次请求使⽤的节点时间
         * start : 下次请求⽂章开始位置
         */

        private String flash_id;
        private String more;
        private String number;
        private String point_time;
        private String start;
        private List<ArticleListBean> article_list;
        private List<BannerListBean> banner_list;
        private List<FlashListBean> flash_list;

        public String getFlash_id() {
            return flash_id;
        }

        public void setFlash_id(String flash_id) {
            this.flash_id = flash_id;
        }

        public String getMore() {
            return more;
        }

        public void setMore(String more) {
            this.more = more;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getPoint_time() {
            return point_time;
        }

        public void setPoint_time(String point_time) {
            this.point_time = point_time;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public List<ArticleListBean> getArticle_list() {
            return article_list;
        }

        public void setArticle_list(List<ArticleListBean> article_list) {
            this.article_list = article_list;
        }

        public List<BannerListBean> getBanner_list() {
            return banner_list;
        }

        public void setBanner_list(List<BannerListBean> banner_list) {
            this.banner_list = banner_list;
        }

        public List<FlashListBean> getFlash_list() {
            return flash_list;
        }

        public void setFlash_list(List<FlashListBean> flash_list) {
            this.flash_list = flash_list;
        }

        public static class ArticleListBean {
            @Override
            public String toString() {
                return "ArticleListBean{" +
                        "column_name='" + column_name + '\'' +
                        ", content='" + content + '\'' +
                        ", description='" + description + '\'' +
                        ", edit_time='" + edit_time + '\'' +
                        ", id='" + id + '\'' +
                        ", image_url='" + image_url + '\'' +
                        ", is_collect='" + is_collect + '\'' +
                        ", is_good='" + is_good + '\'' +
                        ", lead='" + lead + '\'' +
                        ", link='" + link + '\'' +
                        ", share_link='" + share_link + '\'' +
                        ", theme='" + theme + '\'' +
                        ", type='" + type + '\'' +
                        ", video_is_sans_href='" + video_is_sans_href + '\'' +
                        ", video_url='" + video_url + '\'' +
                        ", view_type='" + view_type + '\'' +
                        ", ad=" + ad +
                        '}';
            }

            /**
             * column_name : 栏⽬分类
             * content : ⽂章内容
             * description : ⽂章描述
             * edit_time : ⽂章发布时间
             * id : ⽂章id
             * image_url : ⽂章预览图
             * is_collect : 是否收藏，1已收藏，0未收藏
             * is_good : 是否点赞，1已点赞，0未点赞
             * lead : 导语
             * link : ⽂章链接
             * share_link : ⽂章分享链接
             * theme : ⽂章标题
             * type : ⽂章类型：1新闻，2快讯，3图⽚，4视频，5期刊，6专题,7⼴告
             * video_is_sans_href : 视频是否为外链，1是外链，0不是外链(type是视频时出现)
             * video_url : 视频链接地址(type是视频时出现)
             * view_type : 视图类型：1左图，2中间⼤图，3右图，4视频，5即时
             * ad : {"ad_url":"⼴告资源url","height":"⼴告⾼度，单位px(视频时为0)","id":"⼴告id","layout":"APP⼴告布局:1图⽚开屏，2视频开屏，3图⽚通屏，4图⽚⽆标题，5图⽚有 标题，6视频⽆标题，7视频有标题，8图⽚栏⽬插屏","target_href":"点击⼴告打开的链接","title":"⼴告标题","width":"⼴告宽度，单位px(视频时为0)"}
             */

            private String column_name;
            private String content;
            private String description;
            private String edit_time;
            private String id;
            private String image_url;
            private String is_collect;
            private String is_good;
            private String lead;
            private String link;
            private String share_link;
            private String theme;
            private String type;
            private String video_is_sans_href;
            private String video_url;
            private String view_type;
            private AdBean ad;

            public String getColumn_name() {
                return column_name;
            }

            public void setColumn_name(String column_name) {
                this.column_name = column_name;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getEdit_time() {
                return edit_time;
            }

            public void setEdit_time(String edit_time) {
                this.edit_time = edit_time;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public String getIs_collect() {
                return is_collect;
            }

            public void setIs_collect(String is_collect) {
                this.is_collect = is_collect;
            }

            public String getIs_good() {
                return is_good;
            }

            public void setIs_good(String is_good) {
                this.is_good = is_good;
            }

            public String getLead() {
                return lead;
            }

            public void setLead(String lead) {
                this.lead = lead;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getShare_link() {
                return share_link;
            }

            public void setShare_link(String share_link) {
                this.share_link = share_link;
            }

            public String getTheme() {
                return theme;
            }

            public void setTheme(String theme) {
                this.theme = theme;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getVideo_is_sans_href() {
                return video_is_sans_href;
            }

            public void setVideo_is_sans_href(String video_is_sans_href) {
                this.video_is_sans_href = video_is_sans_href;
            }

            public String getVideo_url() {
                return video_url;
            }

            public void setVideo_url(String video_url) {
                this.video_url = video_url;
            }

            public String getView_type() {
                return view_type;
            }

            public void setView_type(String view_type) {
                this.view_type = view_type;
            }

            public AdBean getAd() {
                return ad;
            }

            public void setAd(AdBean ad) {
                this.ad = ad;
            }

            public static class AdBean {
                @Override
                public String toString() {
                    return "AdBean{" +
                            "ad_url='" + ad_url + '\'' +
                            ", height='" + height + '\'' +
                            ", id='" + id + '\'' +
                            ", layout='" + layout + '\'' +
                            ", target_href='" + target_href + '\'' +
                            ", title='" + title + '\'' +
                            ", width='" + width + '\'' +
                            '}';
                }

                /**
                 * ad_url : ⼴告资源url
                 * height : ⼴告⾼度，单位px(视频时为0)
                 * id : ⼴告id
                 * layout : APP⼴告布局:1图⽚开屏，2视频开屏，3图⽚通屏，4图⽚⽆标题，5图⽚有 标题，6视频⽆标题，7视频有标题，8图⽚栏⽬插屏
                 * target_href : 点击⼴告打开的链接
                 * title : ⼴告标题
                 * width : ⼴告宽度，单位px(视频时为0)
                 */

                private String ad_url;
                private String height;
                private String id;
                private String layout;
                private String target_href;
                private String title;
                private String width;

                public String getAd_url() {
                    return ad_url;
                }

                public void setAd_url(String ad_url) {
                    this.ad_url = ad_url;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getLayout() {
                    return layout;
                }

                public void setLayout(String layout) {
                    this.layout = layout;
                }

                public String getTarget_href() {
                    return target_href;
                }

                public void setTarget_href(String target_href) {
                    this.target_href = target_href;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }
            }
        }

        public static class BannerListBean {
            @Override
            public String toString() {
                return "BannerListBean{" +
                        "description='" + description + '\'' +
                        ", id='" + id + '\'' +
                        ", image_url='" + image_url + '\'' +
                        ", is_collect='" + is_collect + '\'' +
                        ", is_good='" + is_good + '\'' +
                        ", link='" + link + '\'' +
                        ", share_link='" + share_link + '\'' +
                        ", theme='" + theme + '\'' +
                        '}';
            }

            /**
             * description : ⽂章描述
             * id : ⽂章id
             * image_url : ⽂章预览图
             * is_collect : 是否收藏，1已收藏，0未收藏
             * is_good : 是否点赞，1已点赞，0未点赞
             * link : ⽂章链接
             * share_link : ⽂章分享链接
             * theme : ⽂章标题
             */

            private String description;
            private String id;
            private String image_url;
            private String is_collect;
            private String is_good;
            private String link;
            private String share_link;
            private String theme;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public String getIs_collect() {
                return is_collect;
            }

            public void setIs_collect(String is_collect) {
                this.is_collect = is_collect;
            }

            public String getIs_good() {
                return is_good;
            }

            public void setIs_good(String is_good) {
                this.is_good = is_good;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getShare_link() {
                return share_link;
            }

            public void setShare_link(String share_link) {
                this.share_link = share_link;
            }

            public String getTheme() {
                return theme;
            }

            public void setTheme(String theme) {
                this.theme = theme;
            }
        }

        public static class FlashListBean {
            @Override
            public String toString() {
                return "FlashListBean{" +
                        "description='" + description + '\'' +
                        ", id='" + id + '\'' +
                        ", is_collect='" + is_collect + '\'' +
                        ", is_good='" + is_good + '\'' +
                        ", link='" + link + '\'' +
                        ", share_link='" + share_link + '\'' +
                        ", theme='" + theme + '\'' +
                        '}';
            }

            /**
             * description : ⽂章描述
             * id : ⽂章id
             * is_collect : 是否收藏，1已收藏，0未收藏
             * is_good : 是否点赞，1已点赞，0未点赞
             * link : ⽂章链接
             * share_link : ⽂章分享链接
             * theme : ⽂章标题
             */

            private String description;
            private String id;
            private String is_collect;
            private String is_good;
            private String link;
            private String share_link;
            private String theme;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getIs_collect() {
                return is_collect;
            }

            public void setIs_collect(String is_collect) {
                this.is_collect = is_collect;
            }

            public String getIs_good() {
                return is_good;
            }

            public void setIs_good(String is_good) {
                this.is_good = is_good;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getShare_link() {
                return share_link;
            }

            public void setShare_link(String share_link) {
                this.share_link = share_link;
            }

            public String getTheme() {
                return theme;
            }

            public void setTheme(String theme) {
                this.theme = theme;
            }
        }
    }
}
