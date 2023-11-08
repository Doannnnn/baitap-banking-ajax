const createButton = $("#showModalCreate");
const bodyCustomer = $('#tbCustomer');

createButton.on("click", function () {
    $("#createModal").modal("show");
});

const renderCustomer = (obj) => {
    return `
        <tr id="tr_${obj.id}">
            <td>${obj.id}</td>
            <td>${obj.fullName}</td>
            <td>${obj.email}</td>
            <td>${obj.phone}</td>
            <td>${obj.address}</td>
            <td>${obj.balance}</td>
            <td>
                <button class="btn btn-outline-secondary" onclick="showModalUpdate(${obj.id})">
                    <i class="far fa-edit"></i>
                </button>
            </td>
            <td>
                <button class="btn btn-outline-success" data-toggle="modal" onclick="showModalDeposit(${obj.id})">
                    <i class="fas fa-plus"></i>
                </button>
            </td>
            <td>
                <button class="btn btn-outline-warning" data-toggle="modal" onclick="showModalWithdraw(${obj.id})">
                    <i class="fas fa-minus"></i>
                </button>
            </td>
            <td>
                <button class="btn btn-outline-primary" data-toggle="modal" onclick="showModalTransfer(${obj.id})">
                    <i class="fas fa-exchange-alt"></i>
                </button>
            </td>
            <td>
                <button class="btn btn-outline-danger" onclick="disableRecord(${obj.id})">
                    <i class="fas fa-ban"></i>
                </button>
            </td>
        </tr>
    `;
};

const getAllCustomer = () => {
    $.ajax({
        url: "http://localhost:8080/api/customers",
        type: "GET",
        dataType: "json",
        success: function (data) {
            data.forEach(item => {
                const str = renderCustomer(item);
                $("#tbCustomer").append(str);
            });
        },
        error: function (error) {
            console.log("Error:", error);
        }
    });
};

getAllCustomer();

createButton.on('click', async function () {
    const fullName = $('#fullNameCreate').val();
    const email = $('#emailCreate').val();
    const phone = $('#phoneCreate').val();
    const address = $('#addressCreate').val();

    const data = {
        fullName,
        email,
        phone,
        address
    };

    loading.style.display = 'block';

    setTimeout(async function () {
        try {
            const response = await $.ajax({
                url: 'http://localhost:3300/customer',
                method: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data)
            });

            if (response) {
                Swal.fire({
                    icon: "success",
                    title: "Thêm mới thành công",
                    showConfirmButton: false,
                    timer: 1500
                });

                const customerData = response;
                const str = renderCustomer(customerData);
                bodyCustomer.append(str);

                $('#createModal').modal('hide');
            } else {
                webToast.Danger({
                    status: 'Title',
                    message: 'Alert Message'
                });
            }
        } catch (error) {
            console.error('Error:', error);
        } finally {
            loading.style.display = 'none';
        }
    }, 1500);
});

