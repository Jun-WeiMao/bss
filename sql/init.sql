create table CATEGORIES
(
    ID VARCHAR(255) not null
        primary key,
    CREATED_AT TIMESTAMP not null,
    MODIFIED_AT TIMESTAMP,
    VERSION INTEGER,
    CATEGORY_NAME VARCHAR(100) not null
);

create table PRODUCTS
(
    ID VARCHAR(255) not null
        primary key,
    CREATED_AT TIMESTAMP not null,
    MODIFIED_AT TIMESTAMP,
    VERSION INTEGER,
    CODE VARCHAR(255),
    PRICE DECIMAL(19,2) not null,
    PRODUCT_NAME VARCHAR(100) not null,
    PRODUCT_QUANTITY INTEGER,
    SPECIFICATION VARCHAR(255),
    CATEGORY_ID VARCHAR(255) not null,
    constraint FKOG2RP4QTHBTT2LFYHFO32LSW9
        foreign key (CATEGORY_ID) references CATEGORIES (ID)
);

create table CUSTOMIZATIONS
(
    ID VARCHAR(255) not null
        primary key,
    CREATED_AT TIMESTAMP not null,
    MODIFIED_AT TIMESTAMP,
    VERSION INTEGER,
    CUSTOMIZATION_NAME VARCHAR(100) not null,
    DEFAULT_STACK BOOLEAN not null,
    PRICE DECIMAL(19,2) not null,
    PRODUCT_ID VARCHAR(255) not null,
    constraint FKHC5CHCO13KX0GS1JPKQ1M8GLK
        foreign key (PRODUCT_ID) references PRODUCTS (ID)
);

create table DISCOUNTS
(
    ID VARCHAR(255) not null
        primary key,
    CREATED_AT TIMESTAMP not null,
    MODIFIED_AT TIMESTAMP,
    VERSION INTEGER,
    ACTIVE BOOLEAN not null,
    DISCOUNT_RATE DECIMAL(19,2) not null,
    PRODUCT_ID VARCHAR(255),
    constraint FKE3TQXSYXV7QCY8UVF2LNS1HX8
        foreign key (PRODUCT_ID) references PRODUCTS (ID)
);