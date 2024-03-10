window.addEventListener('load', () => {
    // const postListTBody = document.querySelector('#postListTBody')
    const postWrite = document.querySelector('#postWrite')
    postWrite.addEventListener('click', () => {
        location.href = '/postWrite'
    })

//     const refreshTable = () => {
//         requestFn(REQUEST_TYPE.GET, "/sys/post/", null, (data) => {
//             data.forEach(data => {
//                 const tr = document.createElement('tr')
//                 tr.dataset.id = data.id
//                 tr.appendChild(createTitleTd(data))
//                 tr.appendChild(createWriterTd(data))
//                 postListTBody.appendChild(tr)
//             })
//         })
//     }
//
//     const createTitleTd = (data) => {
//         const td = createTd()
//         const a = document.createElement('a')
//         a.textContent = data.title
//         a.href = `/${data.id}`
//         td.appendChild(a)
//         return td
//     }
//
//     const createWriterTd = (data) => {
//         const td = createTd()
//         const a = document.createElement('a')
//         a.textContent = data.writer
// //        a.href = `/${data.id}`
//         td.appendChild(a)
//         return td
//     }
//
//     const createTd = () => {
//         const td = document.createElement('td')
//         td.classList.add(...['text-sm', 'text-secondary', 'mb-0'])
//         td.scope = 'col'
//         td.style.textAlign = 'center'
//         return td
//     }
//     refreshTable()
})
