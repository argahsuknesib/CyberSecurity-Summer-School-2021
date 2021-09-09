package com.mi.global.shop.model;

import org.json.JSONObject;

public class Tags {

    public static final class Activity {
    }

    public static final class AddressInfo {
    }

    public static final class BaiduLbs {
    }

    public interface Category {
    }

    public static final class CategoryTree {
    }

    public static final class CheckCode {
    }

    public static final class CheckoutSubmit {
    }

    public static final class ComboList {
    }

    public static final class Coupon {
    }

    public static final class DelCart {
    }

    public static final class EditConsumption {
    }

    public static final class EditOrder {
    }

    public static final class FCodeSelectProduct {
    }

    public static final class Home {
    }

    public static final class Lottery {
    }

    public static final class LuckyShake {
    }

    public static final class MiHome {
    }

    public static final class MiPhone {
    }

    public static final class MiPhoneDetails {
    }

    public static final class MiPhoneSalesRecord {
    }

    public static final class MihomeBuyInfo {
    }

    public static final class MihomeCheckInfo {
    }

    public static final class Order {
    }

    public static final class OrderSubmit {
    }

    public static final class Phone {
    }

    public static final class PhoneModel {
    }

    public static final class PrepaidRechargeInfo {
    }

    public interface Product {
    }

    public static final class ProductDetails {
    }

    public static final class Purcharser {
    }

    public static final class Push {

        public static final class ShopWaterMarkTypes {
        }
    }

    public static final class RemindInfo {
    }

    public static final class RepairOrder {
    }

    public static final class RepairProgress {
    }

    public static final class ReserveOrder {
    }

    public static final class SaleOutRegister {
    }

    public static final class ServiceStation {
    }

    public static final class ServicesInfo {
    }

    public static final class ShakeCup {
    }

    public static final class ShoppingCartList {
    }

    public static final class ShoppingSupply {
    }

    public static final class UserInfo {
    }

    public static final class VersionUpdate {
    }

    public static boolean isJSONResultOK(JSONObject jSONObject) {
        return jSONObject != null && "ok".equals(jSONObject.optString("result"));
    }

    public final class Recharge {
        public Recharge() {
        }
    }

    public final class CommentInfo {
        public CommentInfo() {
        }
    }

    public final class Review {
        public Review() {
        }
    }

    public final class MiHomeStorage {
        public MiHomeStorage() {
        }
    }

    public final class Kuwan {
        public Kuwan() {
        }
    }

    public final class Nearby {
        public Nearby() {
        }
    }

    public final class PaidService {
        public PaidService() {
        }
    }
}
