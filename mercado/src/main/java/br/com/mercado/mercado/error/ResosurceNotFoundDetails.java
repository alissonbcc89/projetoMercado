package br.com.mercado.mercado.error;

public class ResosurceNotFoundDetails {

    private String title;
    private int status;
    private String details;
    private Long timestamp;
    private String developerMessage;

    private ResosurceNotFoundDetails() {

    }
    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public static final class Builder {
        private String title;
        private int status;
        private String details;
        private Long timestemp;
        private String developerMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder details(String details) {
            this.details = details;
            return this;
        }

        public Builder timestemp(Long timestemp) {
            this.timestemp = timestemp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResosurceNotFoundDetails build() {
            ResosurceNotFoundDetails resosurceNotFoundDetails = new ResosurceNotFoundDetails();
            resosurceNotFoundDetails.details = this.details;
            resosurceNotFoundDetails.status = this.status;
            resosurceNotFoundDetails.developerMessage = this.developerMessage;
            resosurceNotFoundDetails.title = this.title;
            resosurceNotFoundDetails.timestamp = this.timestemp;
            return resosurceNotFoundDetails;
        }
    }
}
