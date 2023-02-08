package br.com.americanas.polotech.treinamentointerface.models;

public enum MFileAnnotationTypeEnum {

        REMINDER(1), IMPORTANT(2), SIMPLE(3), IMAGE(4);
        private Integer MFileAnnotationTypeId;

        MFileAnnotationTypeEnum(Integer MFileAnnotationTypeId) {
            this.MFileAnnotationTypeId = MFileAnnotationTypeId;
        }

        public Integer getMFileAnnotationTypeId () {
            return MFileAnnotationTypeId;
        }

        public static MFileAnnotationTypeEnum getEnumTypeById(Integer id){

            switch (id) {
                case 1: {
                   return MFileAnnotationTypeEnum.REMINDER;

                }
                case 2: {
                    return MFileAnnotationTypeEnum.IMPORTANT;

                }
                case 3: {
                    return MFileAnnotationTypeEnum.SIMPLE;

                }
                case 4: {
                    return MFileAnnotationTypeEnum.IMAGE;

                }
            }
            return null;
        }


}
