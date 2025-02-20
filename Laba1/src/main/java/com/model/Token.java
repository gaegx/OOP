    package main.java.com.model;

    public class Token extends CryptoAsset {
        private String contractAddress;

        protected Token(String assetName, String symbol,String contractAddress, double price,double amount) {
            super(assetName, symbol, price,amount);
            this.contractAddress=contractAddress;
        }

        public static Token CreateToken(String assetName, String symbol,String contractAddress, double price,double amount) {
            return new Token(assetName, symbol,contractAddress, price, amount);
        }
        @Override
         public String gettype() {
            return "Token";
        }

        public String getContractAddress() {
            return contractAddress;
        }

        public void setContractAddress(String contractAddress) {
            this.contractAddress = contractAddress;
        }

    }


