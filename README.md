## Bài tập lớn môn **Công Nghệ JAVA**

### Phần mềm quản lý phòng trọ (Dành cho chủ nhà trọ)

#### Mô tả dự án
- Tên: Phần mềm quản lý phòng trọ (Dành cho chủ trọ)
- Mô tả: Phần mềm tạo ra nhằm mục đích quản lý phòng trọ dành cho chủ nhà trọ. Một chủ trọ sẽ có nhiều dãy trọ để quản lý, phần mềm sẽ cho phép 1 chủ trộ có thể quản lý nhiều dãy trọ cùng lúc trên 1 tài khoản duy nhất mà phần mềm cung cấp. Chủ trọ có thể thêm, sửa, xóa các dãy trọ của mình. Mỗi dãy trọ sẽ có nhiều phòng trọ và tất cả đều được cập nhật quản lý bởi chủ trọ. Trong mỗi dãy trọ có các dịch vụ với mức giá khác nhau, tùy thuộc vào vị trí điều kiện mức sống tại nơi đó mà chủ trọ có thể cập nhật giá các dịch vụ cho từng dãy trọ của mình. Các dịch vụ cơ bản bao gồm: Điện, nước, wifi, vệ sinh, nhà để xe, và các chi phí phát sinh sẽ được tính chung vào phí dịch vụ. Hóa đơn sẽ tính theo tháng, để có sự chính xác 1 tháng sẽ tương đương với 30 ngày, vd: ngày bắt đầu mở dãy trọ (đưa dãy trọ vào hoạt động là ngày 15/2/2022), thì các phòng trọ sẽ phải thanh toán sau 30 ngày (theo ví dụ tức ngày 17/3/2022) các phòng sẽ phải thanh toán hóa đơn. Các thông số cho phí dịch vụ chủ trọ sẽ làm khảo sát tại dãy trọ. Trường hợp các phòng không thanh toán hóa đơn trong tháng này thì khoản tiền đó sẽ được cộng dồn. Khoản nợ có thể trả dần dần.
- Chức năng:
    - Trang chủ: Tìm kiếm phòng, hiển thị danh sách phòng đang trống, hiển thị danh sách phòng chưa thanh toán tiền
    - Quản lý phòng: Tìm kiếm phòng, thêm dãy trọ, hiển thị dãy trọ đang hoạt động.
      - Thêm dãy trọ, thông tin bao gồm: ID dãy trọ, tên dãy trọ, địa chỉ...
      - Hiển thị dãy trọ đang hoạt động (click vào để xem các phòng trọ bên trong dãy trọ): thêm phòng trọ.
        - Thêm phòng trọ bao gồm các thông tin sau: ID phòng trọ, tên phòng trọ, địa chỉ...
        - Chỉnh sửa phòng trọ: Cập nhật các thông tin về tên phòng trọ, số lượng người ở trong 1 phòng trọ, thông tin người ở trong phòng, xóa bỏ người ở ra khỏi phòng, xóa phòng.
        - Thanh toán: Hiển thị list các phòng trong dãy đang hoạt động. Tên phòng, người đứng tên phòng, số điện thoại, tổng tiền cần thanh toán. (click vào xem chi tiết) -> Sẽ hiển thị thông tin của phòng, số điện tiêu thụ, số nước tiêu thụ, các khoản dịch vụ dùng theo tháng(phí vệ sinh, wifi, ...), tổng tiền cần thanh toán, số tiền thanh toán, tiền nợ
      - Chỉnh sửa dãy trọ: cập nhật các thông tin về tên dãy trọ, giá dãy trọ, thêm phòng trọ trong dãy, giá các dịch vụ hoặc xóa bỏ dãy trọ hay cho dãy trọ ngừng hoạt động
    - Cài đặt: Comming Soon
    - About us: Comming Soon
    - Account: hiển thị các thông tin của tài khoản, số lượng dãy trọ quản lý, số lượng phòng đang hoạt động.
    - Update Comming Soon

#### Using for Developers
1. cài đặt IDE intellij: https://www.jetbrains.com/idea/download/#section=windows
2. Cài đặt SceneBuilder: https://gluonhq.com/products/scene-builder/
3. Cài đặt môi trường JAVA, JDK: Tham khảo tại(https://howkteam.vn/course/lap-trinh-java-co-ban-den-huong-doi-tuong/cai-dat-moi-truong-java-3834)
4. cài đặt môi trường lập trình javaFX SDK: https://gluonhq.com/products/javafx/
5. khởi động intellij -> mở project -> Khởi chạy dự án bằng file main.class

#### :clipboard: Target

Trong quá trình xây dựng một phần mềm quản lý, phân tích hệ thống thông tin đóng vai trò rất quan trọng. Có thông tin logic, chính xác với thực tế thì việc lên ý tưởng, xây dựng và thực hiện sản xuất phần mềm mới tối ưu, phù hợp với người sử dụng. Mục tiêu đặt ra là tạo một sản phẩm có các chức năng cơ bản như thêm, sửa, xóa, tìm kiếm. Bằng việc sử dụng các thư viện cơ bản của java, nhóm muốn tạo nên một sản phẩm có giao diện trực quan giống với các phần mềm thực tế trong đó phần mềm có các chức năng, tác vụ cơ bản phù hợp với kiến thức cũng như quy mô hiện tại của nhóm.

#### :speaker: Limit

Phần mềm Quản Lý Phòng Trọ (Dành cho chủ trọ) sẽ quản lý dãy trọ bao gồm những phòng nào. Mỗi phòng sẽ có mã riêng để quản lý. Quản lý số lượng, thông tin của người sử dụng phòng, tổng tiền cần phải thanh toán trong 1 tháng. Các tác vụ mà phần mềm sẽ có như là: Thêm, sửa, xóa, tìm kiếm các đối tượng trọ hay người sử dụng trọ.

#### Environment

- JAVA: https://www.oracle.com/java/technologies/downloads/
- SDK: https://gluonhq.com/products/javafx/

#### JAR
- FontAwesomeFX_commons_9.1.2
- FontAwesomeFX_controls_9.1.2
- FontAwesomeFX_FontAwesome_9.1.2
- mysql_connector_java_8.0.28

#### Libraries
- JavaFX: https://openjfx.io/
- Maven: https://maven.apache.org/
- FXML: https://docs.oracle.com/javafx/2/get_started/fxml_tutorial.htm

#### IDE
- Scene Builder: https://gluonhq.com/products/scene-builder/
- Intellij 2021.3.3
- MySQL, MySQL WorkBench

#### What's included?
- FXML: Thiết kế UI cho chương trình
- JAR: Chứa các thư viện bên ngoài
- Image: Chứa các hình ảnh sử dụng trong chương trình
- Icon: Chứa các bộ icon không nằm trong thư viện icon fontAwesome
- src: chứa mã nguồn chính của chương trình
    - Main: Chạy chương trình chính
    - Controller: Bắt sự kiên của người dùng
    - DatabaseConnection: Liên kết với Database

#### How to Use?
- Comming soon

#### :v: Member
- Dương Văn Hoàng
- Đặng Đình Sang
- Mai Danh Dũng
- Kiều Đạt Quốc Hưng
- Nguyễn Hồ Hưng

#### :mag_right: Place
- English name: University of Transport and Communications campus in HCMC
- Vietnamese name: Trường Đại Học Giao Thông Vận Tải phân hiệu tại TP.Hồ Chí Minh

### Update Comming Soon

