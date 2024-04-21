
    alter table nop_sys_cluster_leader add column NOP_TENANT_ID VARCHAR(32) DEFAULT '0' NOT NULL;

alter table nop_sys_code_rule add column NOP_TENANT_ID VARCHAR(32) DEFAULT '0' NOT NULL;

alter table nop_sys_dict add column NOP_TENANT_ID VARCHAR(32) DEFAULT '0' NOT NULL;

alter table nop_sys_dict_option add column NOP_TENANT_ID VARCHAR(32) DEFAULT '0' NOT NULL;

alter table nop_sys_ext_field add column NOP_TENANT_ID VARCHAR(32) DEFAULT '0' NOT NULL;

alter table nop_sys_i18n add column NOP_TENANT_ID VARCHAR(32) DEFAULT '0' NOT NULL;

alter table nop_sys_lock add column NOP_TENANT_ID VARCHAR(32) DEFAULT '0' NOT NULL;

alter table nop_sys_maker_checker_record add column NOP_TENANT_ID VARCHAR(32) DEFAULT '0' NOT NULL;

alter table nop_sys_notice_template add column NOP_TENANT_ID VARCHAR(32) DEFAULT '0' NOT NULL;

alter table nop_sys_sequence add column NOP_TENANT_ID VARCHAR(32) DEFAULT '0' NOT NULL;

alter table nop_sys_user_variable add column NOP_TENANT_ID VARCHAR(32) DEFAULT '0' NOT NULL;

alter table nop_sys_variable add column NOP_TENANT_ID VARCHAR(32) DEFAULT '0' NOT NULL;

alter table nop_sys_cluster_leader drop constraint PK_nop_sys_cluster_leader;
alter table nop_sys_cluster_leader add constraint PK_nop_sys_cluster_leader primary key (NOP_TENANT_ID, CLUSTER_ID);

alter table nop_sys_code_rule drop constraint PK_nop_sys_code_rule;
alter table nop_sys_code_rule add constraint PK_nop_sys_code_rule primary key (NOP_TENANT_ID, SID);

alter table nop_sys_dict drop constraint PK_nop_sys_dict;
alter table nop_sys_dict add constraint PK_nop_sys_dict primary key (NOP_TENANT_ID, SID);

alter table nop_sys_dict_option drop constraint PK_nop_sys_dict_option;
alter table nop_sys_dict_option add constraint PK_nop_sys_dict_option primary key (NOP_TENANT_ID, SID);

alter table nop_sys_ext_field drop constraint PK_nop_sys_ext_field;
alter table nop_sys_ext_field add constraint PK_nop_sys_ext_field primary key (NOP_TENANT_ID, ENTITY_NAME,ENTITY_ID,FIELD_NAME);

alter table nop_sys_i18n drop constraint PK_nop_sys_i18n;
alter table nop_sys_i18n add constraint PK_nop_sys_i18n primary key (NOP_TENANT_ID, I18N_KEY,I18N_LOCALE);

alter table nop_sys_lock drop constraint PK_nop_sys_lock;
alter table nop_sys_lock add constraint PK_nop_sys_lock primary key (NOP_TENANT_ID, LOCK_GROUP,LOCK_NAME);

alter table nop_sys_maker_checker_record drop constraint PK_nop_sys_maker_checker_record;
alter table nop_sys_maker_checker_record add constraint PK_nop_sys_maker_checker_record primary key (NOP_TENANT_ID, SID);

alter table nop_sys_notice_template drop constraint PK_nop_sys_notice_template;
alter table nop_sys_notice_template add constraint PK_nop_sys_notice_template primary key (NOP_TENANT_ID, SID);

alter table nop_sys_sequence drop constraint PK_nop_sys_sequence;
alter table nop_sys_sequence add constraint PK_nop_sys_sequence primary key (NOP_TENANT_ID, SEQ_NAME);

alter table nop_sys_user_variable drop constraint PK_nop_sys_user_variable;
alter table nop_sys_user_variable add constraint PK_nop_sys_user_variable primary key (NOP_TENANT_ID, USER_ID,VAR_NAME);

alter table nop_sys_variable drop constraint PK_nop_sys_variable;
alter table nop_sys_variable add constraint PK_nop_sys_variable primary key (NOP_TENANT_ID, VAR_NAME);


