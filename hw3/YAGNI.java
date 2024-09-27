public class YAGNI {
    //task 6
    public class User {
        private String Name;
        private String Email;
        private String Address;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            this.Name = name;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            this.Email = email;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String address) {
            this.Address = address;
        }
    }

    //task 7
    public class FileReader {
        public String ReadFile(String filePath) {
            // Чтение без буфера
            return "file content";
        }

        public String ReadBufferedFile(String filePath, int bufferSize) {
            // Чтение с буфером
            return "file content";
        }
    }

    //task 8
    public interface ReportGenerator {
        void generateReport();
    }
    public class PdfReportGenerator implements ReportGenerator {
        @Override
        public void generateReport() {
            // Generate PDF report
        }
    }
    public class ExcelReportGenerator implements ReportGenerator {
        @Override
        public void generateReport() {
            // Generate Excel report
        }
    }
    public class HtmlReportGenerator implements ReportGenerator {
        @Override
        public void generateReport() {
            // Generate HTML report
        }
    }
}
