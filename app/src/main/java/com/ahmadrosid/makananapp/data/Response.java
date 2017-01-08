package com.ahmadrosid.makananapp.data;

import java.util.List;

/**
 * Created by ocittwo on 1/8/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */

public class Response {

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * createdAt : 2017-01-07T19:43:44.355Z
         * metadata : {"description":"Grand Indonesia Mall, Thamrin, Jakarta, Italian, Continental","imgUrl":"https://b.zmtcdn.com/data/pictures/5/7402935/179bfc2e1496e4f48c3549f7bed2d8b8_top_thumb_620_314.jpg","name":"Skype","objectId":null}
         * objectId : 2KOyxvYMm8
         * updatedAt : 2017-01-07T19:43:58.867Z
         */

        private String createdAt;
        private MetadataBean metadata;
        private String objectId;
        private String updatedAt;

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public MetadataBean getMetadata() {
            return metadata;
        }

        public void setMetadata(MetadataBean metadata) {
            this.metadata = metadata;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public static class MetadataBean {
            /**
             * description : Grand Indonesia Mall, Thamrin, Jakarta, Italian, Continental
             * imgUrl : https://b.zmtcdn.com/data/pictures/5/7402935/179bfc2e1496e4f48c3549f7bed2d8b8_top_thumb_620_314.jpg
             * name : Skype
             * objectId : null
             */

            private String description;
            private String imgUrl;
            private String name;
            private Object objectId;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getObjectId() {
                return objectId;
            }

            public void setObjectId(Object objectId) {
                this.objectId = objectId;
            }
        }
    }
}
