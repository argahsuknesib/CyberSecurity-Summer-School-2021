package com.ximalaya.ting.android.xmpayordersdk;

import java.util.HashMap;

public class IXmPayOrderListener$1 extends HashMap<Integer, String> {
    public IXmPayOrderListener$1() {
        put(2, "取消购买");
        put(4, "用户未登录");
        put(110, "未知错误");
        put(101, "网络错误");
        put(102, "下单接口 json提取失败");
        put(200, "下单成功");
        put(500, "下单失败");
        put(100, "参数常规校验失败");
        put(600, "待购买内容已下架");
        put(601, "待购买声音来自不同专辑");
        put(602, "单价校验失败");
        put(603, "已存在未支付订单包含重叠付费音频");
        put(3, "购买类型不支持");
        put(609, "应用没有付费音频接入资格");
        put(615, "已经购买");
        put(1014, "需要登录");
        put(610, "应用IP不在白名单中");
        put(614, "查询价格信息的专辑不存在");
        put(1015, "获取价格信息出错");
        put(401, "订单超时");
        put(430, "订单处理中");
        put(431, "支付宝支付失败");
        put(432, "签名错误");
        put(433, "支付渠道错误");
        put(618, "已经购买");
        put(619, "声音资源是免费试听的，无需购买");
        put(620, "购买的资源是单集购买类型，不能当做整张类型购买");
        put(621, "购买的商品不存在");
    }
}
