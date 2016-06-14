package org.chzz.library;

import java.util.List;

/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/6/8
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/6/8--9:49
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/
public class Bean {


    private String api;
    private String v;

    private DataEntity data;
    private List<String> ret;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public List<String> getRet() {
        return ret;
    }

    public void setRet(List<String> ret) {
        this.ret = ret;
    }

    public static class DataEntity {
        /**
         * id : 2712868300
         * logoUrl : //wwc.alicdn.com/avatar/getAvatar.do?userId=2712868300&width=80&height=80&type=sns
         * accountNick : 迷路的爆米花anna
         * nick : 迷路的爆米花anna
         * accountType : -1
         * two2CodeUrl :
         * jumpType : 0
         * iconList : []
         * taobaoDacu : false
         * double11 : false
         * tmallNianhuo : false
         * isSeller : false
         */

        private AccountEntity account;


        private FeedEntity feed;


        public AccountEntity getAccount() {
            return account;
        }

        public void setAccount(AccountEntity account) {
            this.account = account;
        }

        public FeedEntity getFeed() {
            return feed;
        }

        public void setFeed(FeedEntity feed) {
            this.feed = feed;
        }



        public static class AccountEntity {
            private String id;
            private String logoUrl;
            private String accountNick;
            private String nick;
            private String accountType;
            private String two2CodeUrl;
            private String jumpType;
            private String taobaoDacu;
            private String double11;
            private String tmallNianhuo;
            private String isSeller;


            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLogoUrl() {
                return logoUrl;
            }

            public void setLogoUrl(String logoUrl) {
                this.logoUrl = logoUrl;
            }

            public String getAccountNick() {
                return accountNick;
            }

            public void setAccountNick(String accountNick) {
                this.accountNick = accountNick;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public String getAccountType() {
                return accountType;
            }

            public void setAccountType(String accountType) {
                this.accountType = accountType;
            }

            public String getTwo2CodeUrl() {
                return two2CodeUrl;
            }

            public void setTwo2CodeUrl(String two2CodeUrl) {
                this.two2CodeUrl = two2CodeUrl;
            }

            public String getJumpType() {
                return jumpType;
            }

            public void setJumpType(String jumpType) {
                this.jumpType = jumpType;
            }

            public String getTaobaoDacu() {
                return taobaoDacu;
            }

            public void setTaobaoDacu(String taobaoDacu) {
                this.taobaoDacu = taobaoDacu;
            }

            public String getDouble11() {
                return double11;
            }

            public void setDouble11(String double11) {
                this.double11 = double11;
            }

            public String getTmallNianhuo() {
                return tmallNianhuo;
            }

            public void setTmallNianhuo(String tmallNianhuo) {
                this.tmallNianhuo = tmallNianhuo;
            }

            public String getIsSeller() {
                return isSeller;
            }

            public void setIsSeller(String isSeller) {
                this.isSeller = isSeller;
            }

        }

        public static class FeedEntity {
            private String id;
            private String title;
            private String creatorId;
            private String deleted;
            private String summary;
            private String timestamp;
            private String detailUrl;
            private String top;
            private String feedType;
            /**
             * commentCount : 0
             * feedFavourCount : 0
             * feedFavoriteCount : 0
             * readCount : 0
             */

            private FeedCountEntity feedCount;
            private String needInteractIcon;
            private String needCorner;
            private String needPrice;
            private String needDropDown;
            /**
             * tags : 粉丝节
             * dispatchChannel : toutiao
             * source : common
             * items : 528998537371,528820000285,529365065386,41528697112,43653970033,40680608706,520037446276,529180861715
             * PUBLISH_TIME : 0
             * scenesChannel : toutiao:6
             */

            private FeaturesEntity features;

            /**
             * type : text
             * text : 姑娘们桌子上的东西，每天都在以不可思议的速度增加。
             */

            private List<TilesEntity> tiles;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCreatorId() {
                return creatorId;
            }

            public void setCreatorId(String creatorId) {
                this.creatorId = creatorId;
            }

            public String getDeleted() {
                return deleted;
            }

            public void setDeleted(String deleted) {
                this.deleted = deleted;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }

            public String getDetailUrl() {
                return detailUrl;
            }

            public void setDetailUrl(String detailUrl) {
                this.detailUrl = detailUrl;
            }

            public String getTop() {
                return top;
            }

            public void setTop(String top) {
                this.top = top;
            }

            public String getFeedType() {
                return feedType;
            }

            public void setFeedType(String feedType) {
                this.feedType = feedType;
            }

            public FeedCountEntity getFeedCount() {
                return feedCount;
            }

            public void setFeedCount(FeedCountEntity feedCount) {
                this.feedCount = feedCount;
            }

            public String getNeedInteractIcon() {
                return needInteractIcon;
            }

            public void setNeedInteractIcon(String needInteractIcon) {
                this.needInteractIcon = needInteractIcon;
            }

            public String getNeedCorner() {
                return needCorner;
            }

            public void setNeedCorner(String needCorner) {
                this.needCorner = needCorner;
            }

            public String getNeedPrice() {
                return needPrice;
            }

            public void setNeedPrice(String needPrice) {
                this.needPrice = needPrice;
            }

            public String getNeedDropDown() {
                return needDropDown;
            }

            public void setNeedDropDown(String needDropDown) {
                this.needDropDown = needDropDown;
            }

            public FeaturesEntity getFeatures() {
                return features;
            }

            public void setFeatures(FeaturesEntity features) {
                this.features = features;
            }


            public List<TilesEntity> getTiles() {
                return tiles;
            }

            public void setTiles(List<TilesEntity> tiles) {
                this.tiles = tiles;
            }

            public static class FeedCountEntity {
                private String commentCount;
                private String feedFavourCount;
                private String feedFavoriteCount;
                private String readCount;

                public String getCommentCount() {
                    return commentCount;
                }

                public void setCommentCount(String commentCount) {
                    this.commentCount = commentCount;
                }

                public String getFeedFavourCount() {
                    return feedFavourCount;
                }

                public void setFeedFavourCount(String feedFavourCount) {
                    this.feedFavourCount = feedFavourCount;
                }

                public String getFeedFavoriteCount() {
                    return feedFavoriteCount;
                }

                public void setFeedFavoriteCount(String feedFavoriteCount) {
                    this.feedFavoriteCount = feedFavoriteCount;
                }

                public String getReadCount() {
                    return readCount;
                }

                public void setReadCount(String readCount) {
                    this.readCount = readCount;
                }
            }

            public static class FeaturesEntity {
                private String tags;
                private String dispatchChannel;
                private String source;
                private String items;
                private String PUBLISH_TIME;
                private String scenesChannel;

                public String getTags() {
                    return tags;
                }

                public void setTags(String tags) {
                    this.tags = tags;
                }

                public String getDispatchChannel() {
                    return dispatchChannel;
                }

                public void setDispatchChannel(String dispatchChannel) {
                    this.dispatchChannel = dispatchChannel;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public String getItems() {
                    return items;
                }

                public void setItems(String items) {
                    this.items = items;
                }

                public String getPUBLISH_TIME() {
                    return PUBLISH_TIME;
                }

                public void setPUBLISH_TIME(String PUBLISH_TIME) {
                    this.PUBLISH_TIME = PUBLISH_TIME;
                }

                public String getScenesChannel() {
                    return scenesChannel;
                }

                public void setScenesChannel(String scenesChannel) {
                    this.scenesChannel = scenesChannel;
                }
            }



            public static class TilesEntity {
                private String type;
                private String text;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }
        }
    }
}
