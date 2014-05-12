SET SQLBLANKLINES ON
CREATE TABLE BIOGRAPHIES 
(
  EMPLOYEE_ID NUMBER(6, 0) NOT NULL 
, BIO_UPDATED_DATE DATE NOT NULL 
, BIOGRAPHY CLOB NOT NULL 
, CONSTRAINT BIOGRAPHIES_PK PRIMARY KEY 
  (
    EMPLOYEE_ID 
  )
  ENABLE 
);

CREATE TABLE IMAGES 
(
  IMAGE_ID NUMBER(6, 0) NOT NULL 
, IMAGE VARCHAR2(120) NOT NULL 
, CONSTRAINT IMAGES_PK PRIMARY KEY 
  (
    IMAGE_ID 
  )
  ENABLE 
);

CREATE TABLE IMAGE_USAGES 
(
  IMAGE_ID NUMBER(6, 0) NOT NULL 
, USAGE_TYPE VARCHAR2(1) DEFAULT 'E' NOT NULL 
, ASSOCIATED_ID NUMBER(6, 0) NOT NULL 
, DEFAULT_IMAGE VARCHAR2(1) DEFAULT 'N' NOT NULL 
, CONSTRAINT IMAGE_USAGES_PK PRIMARY KEY 
  (
    IMAGE_ID 
  , USAGE_TYPE 
  , ASSOCIATED_ID 
  )
  ENABLE 
);

ALTER TABLE EMPLOYEES 
ADD (CREATED_BY VARCHAR2(30) );

ALTER TABLE EMPLOYEES 
ADD (CREATED_DATE DATE );

ALTER TABLE EMPLOYEES 
ADD (MODIFIED_BY VARCHAR2(30) );

ALTER TABLE EMPLOYEES 
ADD (MODIFIED_DATE DATE );

ALTER TABLE BIOGRAPHIES
ADD CONSTRAINT BIOGRAPHIES_EMPLOYEES_FK FOREIGN KEY
(
  EMPLOYEE_ID 
)
REFERENCES EMPLOYEES
(
  EMPLOYEE_ID 
)
ENABLE;

ALTER TABLE IMAGE_USAGES
ADD CONSTRAINT IMAGE_USAGES_IMAGES_FK FOREIGN KEY
(
  IMAGE_ID 
)
REFERENCES IMAGES
(
  IMAGE_ID 
)
ENABLE;

COMMENT ON TABLE BIOGRAPHIES IS 'A description of relevant history, accomplishments, and notable events for an employee.';

COMMENT ON TABLE IMAGES IS 'The location of a file containing a picture of the employee.';

COMMENT ON TABLE IMAGE_USAGES IS 'Information about where the image in the IMAGES table is utilized.';

COMMENT ON COLUMN EMPLOYEES.CREATED_BY IS 'The user who inserted this record.';

COMMENT ON COLUMN EMPLOYEES.CREATED_DATE IS 'The time and date when this record was inserted.';

COMMENT ON COLUMN EMPLOYEES.MODIFIED_BY IS 'The user who last updated this record.';

COMMENT ON COLUMN EMPLOYEES.MODIFIED_DATE IS 'The time and date when this record was last updated.';

COMMENT ON COLUMN BIOGRAPHIES.EMPLOYEE_ID IS 'Unique identifierfor the biography text for an employee.';

COMMENT ON COLUMN BIOGRAPHIES.BIO_UPDATED_DATE IS 'The date on which this biography is entered.';

COMMENT ON COLUMN BIOGRAPHIES.BIOGRAPHY IS 'Text that details relevant history, accomplishments, and notable events for the employee.';

COMMENT ON COLUMN IMAGES.IMAGE_ID IS 'The unique identifier for an image.';

COMMENT ON COLUMN IMAGES.IMAGE IS 'A file system path and file name for the graphic file.  The path is relative to the project direcotry.';

COMMENT ON COLUMN IMAGE_USAGES.IMAGE_ID IS 'The image referenced by this usage.';

COMMENT ON COLUMN IMAGE_USAGES.USAGE_TYPE IS 'What this image is associated with, for example, ''E'' means that this is an image for an employee.';

COMMENT ON COLUMN IMAGE_USAGES.ASSOCIATED_ID IS 'The unique ID value (for example, EMPLOYEE_ID) of the object with which the image is associated.';

COMMENT ON COLUMN IMAGE_USAGES.DEFAULT_IMAGE IS '''Y'' if this image is the one used most often for the associated object.  ''N'' otherwise.';

CREATE SEQUENCE IMAGES_SEQ;

UPDATE employees
SET created_by = 'HR',
    created_date = TO_DATE('01/01/1980 12:12','MM/DD/YYYY HH24:MI');

COMMIT;

ALTER TABLE employees
MODIFY (created_by NOT NULL,
        created_date NOT NULL);

CREATE OR REPLACE TRIGGER employees_bi
   BEFORE INSERT
   ON employees
   FOR EACH ROW
BEGIN
   SELECT employees_seq.nextval
   INTO   :new.employee_id
   FROM   dual;
END;
/

CREATE OR REPLACE TRIGGER images_bi
   BEFORE INSERT
   ON images
   FOR EACH ROW
BEGIN
   SELECT images_seq.nextval
   INTO   :new.image_id
   FROM   dual;
END;
/
