package com.example.jiandao.home.view.fragment;

import java.util.List;

public class ColumnBean {
    /**
     * code : 1
     * message : 成功提示
     * data : {"list":[{"id":"栏⽬id","name":"栏⽬名称","description":"⽂章描述","type":"栏⽬类型：1⽤户必须要看到的栏⽬，2⽤户可以取消展示的栏⽬","back_color":"栏⽬背景⾊"},"..."]}
     */

    private String code;
    private String message;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 栏⽬id
             * name : 栏⽬名称
             * description : ⽂章描述
             * type : 栏⽬类型：1⽤户必须要看到的栏⽬，2⽤户可以取消展示的栏⽬
             * back_color : 栏⽬背景⾊
             */

            private String id;
            private String name;
            private String description;
            private String type;
            private String back_color;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getBack_color() {
                return back_color;
            }

            public void setBack_color(String back_color) {
                this.back_color = back_color;
            }
        }
    }
}
