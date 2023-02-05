package br.com.americanas.polotech.treinamentointerface.enumns;

public enum MFileAnnotationTypeEnum {

        REMINDER(1), IMPORTANT(2), SIMPLE(3), IMAGE(4);
        private Integer MFileAnnotationTypeId;

        MFileAnnotationTypeEnum(Integer iphoneTypeId) {
            this.MFileAnnotationTypeId = iphoneTypeId;
        }

        public Integer getIphoneTypeId () {
            return MFileAnnotationTypeId;
        }


}
