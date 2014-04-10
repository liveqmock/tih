package com.wcs.tih.filenet.pe.consts;

public interface WorkflowConsts {

	// workflow
	String NOT_PASS = "NOTPASS";

	String PASS = "PASS";

	String WORK_FLOW_SUPERVISOR = "supervisor";

	String WORK_FLOW_PARAM_SUPERVISOR = "supervisor_param";

	String WORK_FLOW_AUDITER = "auditer";

	String WORK_FLOW_PARAM_AUDITER = "auditer_param";

	String WORK_FLOW_PARAM_ASSIGNER = "assigner_param";

	String WORK_FLOW_PARAM_CREATOR = "creator_param";

	String WORK_FLOW_PARAM_HELPER = "helper_param";

	String TIH_AUDITE_OPIONION = "TIH.AUDITE.OPIONION";

	String TIH_WORKFLOW_DOCUMENT_ID = "TIH.WORKFLOW.DOCUMENT.ID";
	String TIH_WORKFLOW_DCOUMENT_CHECKIN_ID = "TIH_WORKFLOW_DCOUMENT_CHECKIN_ID";
	String TIH_DCOUMENT_CHECKIN_PERMISSION = "TIH.DCOUMENT.CHECKIN.PERMISSION";

	String TIH_CHECKIN_DOCUMENT_AUDIT_WORKFLOW = "TIHCheckinDocumentAuditWorkflow";

	String UPLOAD_DOCUMENT_AUDIT_WORKFLOW = "UploadDocumentAuditWorkFlow";
	// filenet
	int FIELD_TYPEDEF_TIME64 = 256;
	int FIELD_TYPE_GUID = 512;
	int BASIC_FIELD_TYPES = 31;
	int ALL_FIELD_TYPES = 767;

	String TIME_MASK = "MM/dd/yyyy HH:mm:ss";
	String TIME_MASK_CANONICAL = "mm/dd/yyyy hh:tt:ss";
	int MAX_IDENTIFIER_LENGTH = 128;

	// AskWorkflow
	String TIH_WORKFLOW_APPLYQUE_QUESTIONHEAD = "TIH.WORKFLOW.APPLYQUE.QUESTIONHEAD";
	String TIH_WORKFLOW_APPLYQUE_OPIONION = "TIH.WORKFLOW.APPLYQUE.OPIONION";
	String TIH_WORKFLOW_APPLYQUE_FILEID = "TIH.WORKFLOW.APPLYQUE.FILEID";
	String TIH_WORKFLOW_APPLYQUE_FILENAME = "TIH.WORKFLOW.APPLYQUE.FILENAME";
	String TIH_WORKFLOW_APPLYQUE_RECIPIENT = "TIH.WORKFLOW.APPLYQUE.RECIPIENT"; // 收件人
	String TIH_WORKFLOW_APPLYQUE_CC = "TIH.WORKFLOW.APPLYQUE.CC";//抄送人

	// 第一个是工作流名,下面四个是每个岗位的内置参数
	String ASK_WORKFLOW_NAME = "AskWorkflow";
	String ASK_FLOW_PARAM_ANSWER = "answer_param";
	String ASK_FLOW_PARAM_ASKER = "asker_param";
	String ASK_FLOW_PARAM_HELPER = "helper_param";
	String ASK_FLOW_PARAM_ASSIGNER = "assigner_param";

	// 流程里每个节点的名称
	String ASKWORKFLOW_LAUNCH_STEP = "LaunchStep";
	String ASKWORKFLOW_ANSWER_STEP = "回答人岗";
	String ASKWORKFLOW_HELPER_STEP = "协助回答岗";
	String ASKWORKFLOW_ASSIGNER_STEP = "转签回答岗";
	String ASKWORKFLOW_ASKER_STEP = "提问人岗";

	// 每个岗位的指向状态
	String ANSWER_STATUS = "answer_status";
	String HELPER_STATUS = "helper_status";
	String ASSIGNER_STATUS = "assigner_status";
	String ASKER_STATUS = "asker_status";

	// 回答人岗位的指向路径参数
	String ANSWER_SENDTO_ASKER = "ASK";
	String ANSWER_SENDTO_HELPER = "HELP";
	String ANSWER_SENDTO_ASSIGNER = "ASSIGN";

	// 协助人岗位的指向路径参数
	String HELPER_SENDTO_ANSWER = "ANSWER";
	String HELPER_SENDTO_ASSIGNER = "ASSIGN";

	// 提问人岗位的指向路径参数
	String ASKER_SENDTO_ANSWER = "ANSWER";
	String ASKER_SENDTO_ASSIGNER = "ASSIGN";
	String ASKER_SENDTO_OVER = "OVER";

	// 转签岗指向的路径参数
	String ASSIGNER_SENDTO_ANSWER = "ANSWER";
	String ASSIGNER_SENDTO_HELPER = "HELP";
	String ASSIGNER_SENDTO_ASKER = "ASK";

	// 报送报表流程参数
	// 流程名称
	String SENDREPORT_WORKFLOW_NAME = "TIHSendReportWorkflow";
	// 流程节点参数
	String SENDREPORT_PARAM_SUPERVISOR = "supervisor_param";
	String SENDREPORT_PARAM_PROCESSOR = "processor_param";
	String SENDREPORT_PARAM_AUDITOR = "auditor_param";
	// 流程节点名
	String SENDREPORT_NAME_SUPERVISOR = "报表处理岗主管";
	String SENDREPORT_NAME_PROCESSOR = "公司报表处理岗";
	String SENDREPORT_NAME_AUDITOR = "集团报表审核岗";
	// 流程路由名称
	String SENDREPORT_PARAM_STATUS = "status";
	// 流程路由参数,除了公司报表处理岗是只是"SEND"外,其他2个都是通过和未通过两个路由参数
	String SENDREPORT_STATUS_SEND = "SEND";
	String SENDREPORT_STATUS_PASS = "PASS";
	String SENDREPORT_STATUS_NOPASS = "NOPASS";

	// 报送报表流程存到数据库用的一些键的值
	String SENDREPORT_SQLKEY_COMPANY = "TIH.WORKFLOW.SENDREPORT.COMPANYNAME";// 存的是oid
	String SENDREPORT_SQLKEY_REPORT_ATTNAME = "TIH.WORKFLOW.SENDREPORT.REPORT.ATTNAME";
	String SENDREPORT_SQLKEY_REPORT_ATTID = "TIH.WORKFLOW.SENDREPORT.REPORT.ATTID";
	String SENDREPORT_SQLKEY_OPINION = "TIH.WORKFLOW.SENDREPORT.OPINION";
	String SENDREPORT_SQLKEY_REPORT_TYPE = "TIH.WORKFLOW.SENDREPORT.REPORT.TYPE";
	String SENDREPORT_SQLKEY_REPORT_SQLTABLEID = "TIH.WORKFLOW.SENDREPORT.REPORT.SQLTABLEID"; // 存储对应表的ID
	String SENDREPORT_SQLKEY_REPORT_STATISTIC_TIME = "TIH.WORKFLOW.SENDREPORT.REPORT.STATISTIC.TIME";// 报表统计时间

	String SENDREPORT_SUBTOTAL = "小计";
	String SENDREPORT_RATIO = "比例";

	// 集团情况反馈流程
	// 流程节点参数
	String PASSWORD_PARAM_COMPANY = "companyer_param";
	String PASSWORD_PARAM_SUPERVISOR = "supervisor_param";
	String PASSWORD_PARAM_AUDITOR = "auditor_param";

	// 超时邮件申请单类型
	String TIMEOUT_EMAIL_REQUESTFORM_TYPE = "TIMEOUT.EMAIL.REQUESTFORM.TYPE";
}
