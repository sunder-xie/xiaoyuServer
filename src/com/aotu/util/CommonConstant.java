package com.aotu.util;

import java.math.BigDecimal;

/**
 * 公共业务常量类
 */
public class CommonConstant {

	/**
	 * 可见
	 */
	public static String SHOW = "1";
	
	/**
	 * 不可见
	 */
	public static String HIDE = "0";
	
	/**
	 * 教师状态-注册审核中
	 */
	public static String CHECK_CONSTANT = "0";
	
	/**
	 * 教师状态-启用
	 */
	public static String USING_CONSTANT = "1";
	
	/**
	 * 教师状态-删除
	 */
	public static String DEL_CONSTANT = "2";
	
	/**   
	  * @Title: 日志状态-插入
	  * @author ljn   
	  * @date 2016-2-25 
	  */
	public static String LOG_INSERT = "1";
	
	/**   
	  * @Title: 日志状态-更新
	  * @author ljn   
	  * @date 2016-2-25 
	  */
	public static String LOG_UPDATE = "2";
	
	/**   
	  * @Title: 日志状态-删除
	  * @author ljn   
	  * @date 2016-2-25 
	  */
	public static String LOG_DEL = "3";
	
	/**   
	 * @Title: 活动日志状态-发布
	 * @author ljn   
	 * @date 2016-2-25 
	 */
	public static String CLUBACTIVITIES_LOG_INFORM = "4";
	
	/**   
	 * @Title: 活动日志状态-终止
	 * @author ljn   
	 * @date 2016-2-25 
	 */
	public static String CLUBACTIVITIES_LOG_END = "5";
	
	/**   
	 * @Title: 活动日志状态-延期
	 * @author ljn   
	 * @date 2016-2-25 
	 */
	public static String CLUBACTIVITIES_LOG_POSTPONE = "6";
	
	/**   
	  * @Title: 跳转状态-更新
	  * @author ljn   
	  * @date 2016-2-25 
	  */
	public static String TO_UPDATE = "1";
	
	/**   
	  * @Title: 跳转状态-查看
	  * @author ljn   
	  * @date 2016-2-25 
	  */
	public static String TO_VIEW = "2";
	
	/**   
	  * @Title: 用户状态-可用 
	  * @author ljn   
	  * @date 2016-2-25 
	  */
	public static String USER_STATUS = "1";
	
	/**   
	  * @Title:	优惠活动-启用  
	  * @author ljn   
	  * @date 2016-2-26 
	  */
	public static String PROMOTION_OPEN="1";
	/**   
	 * @Title:	优惠活动-停用  
	 * @author ljn   
	 * @date 2016-2-26 
	 */
	public static String PROMOTION_STOP="0";
	/**   
	 * @Title:	优惠活动-过期 
	 * @author ljn   
	 * @date 2016-2-26 
	 */
	public static String PROMOTION_STALE="2";
	/**   
	 * @Title:	活动状态-未通过（未发布） 
	 * @author ljn   
	 * @date 2016-2-26 
	 */
	public static String CLUBACTIVITIES_NO="0";
	/**   
	 * @Title:	活动状态-已通过（已发布） 
	 * @author ljn   
	 * @date 2016-2-26 
	 */
	public static String CLUBACTIVITIES_YES="1";
	/**   
	 * @Title:	活动状态-活动终止 
	 * @author ljn   
	 * @date 2016-2-26 
	 */
	public static String CLUBACTIVITIES_STOP="2";
	/**   
	 * @Title:	优惠活动-活动结束
	 * @author ljn   
	 * @date 2016-2-26 
	 */
	public static String CLUBACTIVITIES_OVER="3";
	/**   
	 * @Title:	标识-1
	 * @author ljn   
	 * @date 2016-2-26 
	 */
	public static String FLAG_1="1";
	/**   
	 * @Title:	标识-2
	 * @author ljn   
	 * @date 2016-2-26 
	 */
	public static String FLAG_2="2";
	/**   
	 * @Title:	标识-3
	 * @author ljn   
	 * @date 2016-2-26 
	 */
	public static String FLAG_3="3";
	/**   
	 * @Title:	标识-4
	 * @author ljn   
	 * @date 2016-2-26 
	 */
	public static String FLAG_4="4";
	/**   
	 * @Title:	活动报名状态-报名成功 
	 * @author ljn   
	 * @date 2016-2-26 
	 */
	public static String ENROLL_STATUS_YES="1";
	/**   
	 * @Title:	活动报名状态-取消报名 
	 * @author ljn   
	 * @date 2016-2-26 
	 */
	public static String ENROLL_STATUS_NO="2";
	/**   
	 * @Title:	新闻状态-未发布 
	 * @author ljn   
	 * @date 2016-2-26 
	 */
	public static String CLUBNEWS_NO="0";
	/**   
	 * @Title:	新闻状态-已发布 
	 * @author ljn   
	 * @date 2016-2-26 
	 */
	public static String CLUBNEWS_YES="1";
	/**   
	 * @Title:	是否可用-0:不可用
	 * @author ljn   
	 * @date 2016-2-26 
	 */
	public static String ENABLED_NO = "0";
	/**   
	 * @Title:	是否可用-1:可用
	 * @author ljn   
	 * @date 2016-2-26 
	 */
	public static String ENABLED_YES = "1";
	
	/**
	 * 性别, 男
	 */
	public static String G_MALE = "male"; 
	
	/**
	 * 性别女
	 */
	public static String G_FEMALE = "female"; 
	
	/**
	 * 是否为俱乐部(总部)
	 */
	public static String IS_CLUB_HQ = "0";
	
	/**
	 * 是否为俱乐部(admin - 超级管理员)
	 */
	public static String IS_CLUB_ADMIN = "0";
	
	/**
	 * 是否为俱乐部(俱乐部总校区)
	 */
	public static String IS_CLUB_HC = "1";
	
	/**
	 * 是否为俱乐部(校区)
	 */
	public static String IS_CLUB_SS = "2";
	
	/**   
	  * @Title: 拓展属性：父 
	  * @author ljn   
	  * @date 2016-3-3 
	  */
	public static String PARENT = "0"; 
	
	/**
	 * 缴费方式(一次性缴费)
	 */
	
	public static String PAY_ALL = "0";
	/**
	 * 缴费方式(按次缴费)
	 */
	public static String PAY_ONCE = "1";
	
	/**
	 * 缴费方式(先上课后缴费)
	 */
	public static String PAY_AFTER = "2";
	
	/**
	 * 当前已上课数，新建课程时为0，每上一节课则update该记录+1
	 */
	public static Integer CURRENT_COURSES = 0;
	
	/**
	 * 班级报名状态(0 - 未开放报名)
	 */
	public static String CLASS_ENROLL_STATUS_NO = "0";
	
	/**
	 * 班级报名状态(1 - 已开放报名)
	 */
	public static String CLASS_ENROLL_STATUS_YES = "1";
	
	/**
	 * 班级报名状态(0 - 已结束报名)
	 */
	public static String CLASS_ENROLL_STATUS_ED = "2";
	
	/**
	 * 班级排表状态 (0 - 未排表)
	 */
	public static String IS_SCHEDULE_NO = "0";
	
	/**
	 * 班级排表状态 (0 - 已排表)
	 */
	public static String IS_SCHEDULE_YES = "1";
	
	/**
	 * 课程状态(0 - 未开始上课)
	 */
	public static String SCHEDULE_STATUS_NO = "0";
	
	/**
	 * 课程状态(1 - 已开始上课)
	 */
	public static String SCHEDULE_STATUS_YES = "1";
	/**
	 * 课程状态(2 - 班级结束)
	 */
	public static String SCHEDULE_STATUS_END = "2";
	/**
	 * 课程状态(3 - 班级终止)
	 */
	public static String SCHEDULE_STATUS_DOWN = "3";
	
	/**
	 * 是否原价 (0 - 非原价)
	 */
	public static String IS_ORIGINAL_NO = "0";
	
	/**
	 * 是否原价 (0 - 是原价)
	 */
	public static String IS_ORIGINAL_YES = "1";
	
	/**
	 * 用户类型(0 - 教工)
	 */
	public static String USER_TYPE_STAFF = "0";
	
	/**
	 * 用户类型(1 - 教师)
	 */
	public static String USER_TYPE_TEACHER = "1";
	
	/**
	 * 用户类型(2 - 学生)
	 */
	public static String USER_TYPE_STUDENT = "2";
	
	/**
	 * 用户类型(3 - 监护人)
	 */
	public static String USER_TYPE_GUARDIAN = "3";
	
	/**   
	  * @Title: 账户金额默认值
	  * @author ljn   
	  * @date 2016-3-10 
	  */
	public static BigDecimal ACCOUNT_AMOUNT_INIT=BigDecimal.valueOf(0) ;
	/**   
	 * @Title: 金额日志-进-0
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String AMOUNT_LOG_ADD="0" ;
	/**   
	 * @Title: 金额日志-出-1
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String AMOUNT_LOG_MINUS="1" ;
	/**   
	 * @Title: 金额类型-0现金
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String AMOUNT_TYPE_CASH="0" ;
	/**   
	 * @Title: 金额类型-1退课费
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String AMOUNT_TYPE_DROP="1" ;
	/**   
	 * @Title: 金额类型-2俱乐部赠送
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String AMOUNT_TYPE_DONATE="2" ;
	/**   
	 * @Title: 金额类型-3联盟抵用金
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String AMOUNT_TYPE_COMMISSION="3" ;
	/**   
	 * @Title: 账户使用顺序-1对应退课费
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String APPLY_ORDER_DROP="1" ;
	/**   
	 * @Title: 账户使用顺序-2俱乐部赠送
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String APPLY_ORDER_DONATE="2" ;
	/**   
	 * @Title: 账户使用顺序-98联盟抵用券
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String APPLY_ORDER_COMMISSION="98" ;
	/**   
	 * @Title: 账户使用顺序-99现金账户
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String APPLY_ORDER_CASH="99" ;
	/**   
	 * @Title: 可退还-0不可
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String CAN_RETURN_NO="0" ;
	/**   
	 * @Title: 可退还-1可以
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String CAN_RETURN_YES="1" ;
	/**   
	 * @Title: 可消费-0不可
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String CAN_CONSUME_NO="0" ;
	/**   
	 * @Title: 可消费-1可以
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String CAN_CONSUME_YES="1" ;
	/**   
	 * @Title: 支付状态-0不成功
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String PAYMENT_STATUS_NO="0" ;
	/**   
	 * @Title: 支付状态-1成功
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String PAYMENT_STATUS_YES="1" ;
	/**   
	 * @Title: 支付状态-1成功
	 * @author ljn   
	 * @date 2016-3-10 
	 */
	public static String OUTCOME="提交" ;
	
	/**
	 * 请假是否扣课时费(0 - 不扣)
	 */
	public static String IS_DEDUCT_NO = "0";
	
	/**
	 * 请假是否扣课时费(1 - 扣)
	 */
	public static String IS_DEDUCT_YES = "1";
	
	/**
	 * 是否避开法定节假日(0 - 不避开)
	 */
	public static String AVOIDHOLIDAY_NO = "0";
	
	/**
	 * 是否避开法定节假日(1 - 避开)
	 */
	public static String AVOIDHOLIDAY_YES = "1";
	
	/**
	 * 判断是否为节假日的接口参数规范
	 */
	public static String IS_LEGALHOLIDAYS_PARAMTER = "d=";
	
	/**
	 * 判断是否为节假日的接口URL
	 */
	public static String IS_LEGALHOLIDAYS_URL = "http://www.easybots.cn/api/holiday.php";
	
	/**
	 * 是否为法定节假日判断结果(0 - 工作日)
	 */
	public static String LEGALHOLIDAYS_WORKINGDAY = "0";
	
	/**
	 * 是否为法定节假日判断结果(1 - 休息日)
	 */
	public static String LEGALHOLIDAYS_OFFDAY = "1";
	
	/**
	 * 是否为法定节假日判断结果(2 - 节假日)
	 */
	public static String LEGALHOLIDAYS_HOLIDAY = "2";
	
	/**
	 * 教师是否有过请假单(0 - 没有请假)
	 */
	public static String TEACHER_LEAVE_NO = "0";
	
	/**
	 * 教师是否有过请假单(1 - 请假)
	 */
	public static String TEACHER_LEAVE_YES = "1";
	
	/**
	 * 通用YES
	 */
	public static String COMMON_YES = "1";
	
	/**
	 * 通用NO
	 */
	public static String COMMON_NO = "0";
	
	/**
	 * 学员班级状态正常
	 */
	public static String STUDENT_CLASS_NORMAL_STAT = "1";
	
	/**
	 * 学员班级状态退班
	 */
	public static String STUDENT_CLASS_QUIT_STAT = "2";
	
	/**
	 * 班级是否可以超员(0 - 不可超员)
	 */
	public static String IS_SURCHAGE_NO = "0";
	
	/**
	 * 班级是否可以超员(1 - 可以超员)
	 */
	public static String IS_SURCHAGE_YES = "1";
	
	/**
	 * 学员报名订单状态(0 - 待支付)
	 */
	public static String ORDER_STATUS_NOPAY = "0";
	
	/**
	 * 学员报名订单状态(1 - 订单完成)
	 */
	public static String ORDER_STATUS_PAYED = "1";
	
	/**
	 * 学员报名订单状态(2 - 交易关闭)
	 */
	public static String ORDER_STATUS_PAY_CLOSED = "2";
	
	/**
	 * 学员报名报名状态(0 - 报名未成功)
	 */
	public static String REGISTRATION_NO = "0";
	
	/**
	 * 学员报名报名状态(1 - 报名成功)
	 */
	public static String REGISTRATION_YES = "1";
	
	/**
	 * 学员报名报名状态(1 - 报名取消)
	 */
	public static String REGISTRATION_CANCEL = "2";
	
	/**
	 * 学员是否调班(0 - 未调班)
	 */
	public static String IS_EXCHANGE_NO = "0";
	
	/**
	 * 学员是否调班(1 - 已调班)
	 */
	public static String IS_EXCHANGE_YES = "1";
	
	/* 照片类型 - 头像 */
	public static String PHOTO_TYPE_MAIN = "0";
	/* 照片类型 - 生活照 */
	public static String PHOTO_TYPE_LIVING = "1";
	
	/* 图片服务器地址 */
    public static String PICTURE_SITE_URL = "PICTURE_SITE_URL";
	
	/**   
	  * @Title: 日期格式
	  * @author ljn   
	  * @date 2016-3-20 
	  */
	public static String DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 下载用常量 -- 语言格式编码
	 */
	public static String DOWN_LOAD_ENCODING = "UTF-8";
	
	/**
	 * 下载用常量 -- contentType
	 */
	public static String DOWN_LOAD_CONTENTTYPE = "multipart/form-data";
	
	/**
	 * 下载用常量 -- 浏览器头部设置
	 */
	public static String DOWN_LOAD_HEADER_FIRST = "Content-Disposition";
	
	/**
	 * 下载用常量 -- contentType
	 */
	public static String DOWN_LOAD_HEADER_LAST = "attachment;fileName=";
	
	/**
	 * 下载用常量 -- 下载文件类型(浏览器)
	 */
	public static String DOWN_LOAD_TYPE_BROWSER = "BROWSER_EXE";
	
	/**
	 * 下载用常量 -- 下载文件类型(学生Excel模板)
	 */
	public static String DOWN_LOAD_TYPE_S_TEMPLATE = "S_TEM_EXC";
	
	/**
	 * 下载用常量 -- 下载文件(谷歌浏览器)存放根目录
	 */
	public static String GOOGLE_DOWN_LOAD_ROOT_DIRECTORY = "/WEB-INF/downLoad/googleBrowser";
	
	/**
	 * 下载用常量 -- 下载文件(导入学生Excel模板)存放根目录
	 */
	public static String S_TEMPLATE_DOWN_LOAD_ROOT_DIRECTORY = "/WEB-INF/downLoad/studentExcelTemplate";
	
	/**
	 * 上传用常量 -----> 学生信息导入模板
	 * 上传不同类型的文件依靠此常量存放于不同的文件夹中, 方便归档
	 */
	public static String UPLOAD_TYPE_S_TEMPLATE = "student_template";
	
	/**
	 * 上传用常量 -----> 学生信息导入模板所存放的文件夹名称
	 */
	public static String UPLOAD_S_TEMPLATE_DIRECTORYNAME = "studentsInfoExcel";
	
	/**
	 * 上课记录状态 - 未发布
	 */
	public static String CLASS_HISTORY_RECORD_STATUS_UNPUBLISH = "0";
	
	/**
	 * 上课记录状态 - 已发布
	 */
	public static String CLASS_HISTORY_RECORD_STATUS_PUBLISHED = "1";
	
	/**
	 * 是否延期生成课表 -- 不延期
	 */
	public static String CLASS_CLASSSCHEDULE_POSTPONE_NO = "POSTPONE_NO";
	
	/**
	 * 是否延期生成课表 -- 延期
	 */
	public static String CLASS_CLASSSCHEDULE_POSTPONE_YES = "POSTPONE_YES";
	
	
}
