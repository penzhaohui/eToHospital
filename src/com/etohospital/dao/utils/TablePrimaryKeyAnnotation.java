package com.etohospital.dao.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented()
@Inherited()
public @interface TablePrimaryKeyAnnotation {
	String TableName() default "";
	String PrimaryKey() default "";
}

//Java���ṩ������Ԫע�⣬ר�Ÿ���ע��������ע�⣬�ֱ�����
//@RetentionԪע�⣬��ʾ��Ҫ��ʲô���𱣴��ע����Ϣ���������ڣ�����ѡ��RetentionPoicy����������
//RetentionPolicy.SOURCE: ͣ����javaԴ�ļ���������������
//RetentionPolicy.CLASS��ͣ����class�ļ��У����ᱻVM������Ĭ�ϣ�
//RetentionPolicy.RUNTIME���ڴ��е��ֽ��룬VM��������ʱҲ����ע�⣬��˿���ͨ��������ƶ�ȡע�����Ϣ

//@TargetԪע�⣬Ĭ��ֵΪ�κ�Ԫ�أ���ʾ��ע������ʲô�ط������õ�ElementType��������
//ElementType.CONSTRUCTOR: ����������
//ElementType.FIELD: ��Ա�������������ԣ�����enumʵ����
//ElementType.LOCAL_VARIABLE: �ֲ���������
//ElementType.METHOD: ��������
//ElementType.PACKAGE: ������
//ElementType.PARAMETER: ��������
//ElementType.TYPE: �ࡢ�ӿڣ�����ע������)��enum����

//@Documented��ע�������JavaDoc��
//@Inheried��������̳и����е�ע��