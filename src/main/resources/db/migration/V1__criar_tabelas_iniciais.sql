CREATE TABLE REGIAO (
                        ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                        NOME VARCHAR2(100) NOT NULL,
                        RISCO VARCHAR2(20),
                        LATITUDE NUMBER,
                        LONGITUDE NUMBER
);

CREATE TABLE SENSOR (
                        ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                        CODIGO VARCHAR2(50) NOT NULL,
                        TIPO VARCHAR2(50),
                        ATIVO NUMBER(1),
                        REGIAO_ID NUMBER REFERENCES REGIAO(ID)
);

CREATE TABLE FOCO_INCENDIO (
                               ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                               DATA_HORA TIMESTAMP NOT NULL,
                               SEVERIDADE NUMBER(1),
                               SENSOR_ID NUMBER REFERENCES SENSOR(ID)
);

CREATE TABLE AGENTE_AMBIENTAL (
                                  ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                  NOME VARCHAR2(100),
                                  MATRICULA VARCHAR2(20),
                                  REGIAO_ATUACAO_ID NUMBER REFERENCES REGIAO(ID)
);

CREATE TABLE ALERTA (
                        ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                        FOCO_ID NUMBER REFERENCES FOCO_INCENDIO(ID),
                        DATA_ALERTA TIMESTAMP,
                        STATUS VARCHAR2(20),
                        AGENTE_ID NUMBER REFERENCES AGENTE_AMBIENTAL(ID)
);
